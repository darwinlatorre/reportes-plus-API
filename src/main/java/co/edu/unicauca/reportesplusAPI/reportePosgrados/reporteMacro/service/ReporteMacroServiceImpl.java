package co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service.ConsolidadoService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO.IngresosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO.IngresosEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.mapper.IngresosMapper;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.DTOs.ReporteMacroDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReporteMacroServiceImpl implements ReporteMacroService {
    @Autowired
    private CodigosDAO codigosDAO;
    @Autowired
    private ConsolidadoService consolidadoService;
    @Autowired
    private GastoDAO gastosDAO;
    @Autowired
    private IngresosDAO ingresosDAO;
    @Autowired(required = true)
    private IngresosMapper ingresoMapper;

    @Override
    public ReporteMacroDTORes generarReporteMacro(Date fechaInicio, Date fechaFin, String fragmentoCodigo) throws SQLException {
        List<CodigoEntity> codigos = codigosDAO.encontrarTodosLosCodigos();
        ReporteMacroDTORes reporte = new ReporteMacroDTORes();

        reporte.setConsolidados(new ArrayList<>());
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);

        //filtrar solo los codigos de posgrados
        for(CodigoEntity codigo:codigos)
        {
            if(codigo.getCodigo().startsWith(fragmentoCodigo)) {
                //Obtener el total de gastos
                List<GastoEntity> GastoEntityList = gastosDAO.encontrarReportesPorFechaYCodigo(ajustarFecha(fechaInicio),
                        ajustarFecha(fechaFin), codigo.getCodigo());
                BigDecimal gastoTotal = GastoEntityList.stream()
                        .map(GastoEntity::getValor_definitivo)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                //Obtener ingresos y descuentos
                List<IngresosEntity> ingresosSinMapear = ingresosDAO.encontrarReportesPorFechaYCodigo(ajustarFecha(fechaInicio), ajustarFecha(fechaFin), codigo.getCodigo());

                List<IngresoDTORes> listaIngresosPositivos = new ArrayList<>();
                List<IngresoDTORes> listaDescuentos = new ArrayList<>();

                for (IngresosEntity ingresosEntity : ingresosSinMapear) {
                    Date fechaGasto = ingresosEntity.getFecha();
                    String cuentaMovimiento = ingresosEntity.getCuenta_movimiento();
                    String codigoTipo = cuentaMovimiento.substring(cuentaMovimiento.lastIndexOf(".") + 1);

                    if (fechaGasto.before(fechaFin) && fechaGasto.after(fechaInicio) && codigoTipo.equals(codigo.getCodigo())) {
                        IngresoDTORes ingresoDTO = ingresoMapper.ingresoEntityToIngresoDTO(ingresosEntity);
                        double valorEjecutado = ingresosEntity.getValor_ejecutado().doubleValue(); // Convertir a double
                        if (ingresoDTO.getObservacion().contains("DESCUENTO") || ingresoDTO.getObservacion().contains("DESCUENTOS")) {
                            listaDescuentos.add(ingresoDTO);
                        } else {
                            listaIngresosPositivos.add(ingresoDTO);
                        }
                    }
                }

                // sacar la suma de los ingresos y la suma de los descuentos
                BigDecimal sumaIngreso = new BigDecimal((float) listaIngresosPositivos.stream()
                        .mapToDouble(gasto -> (double) gasto.getValor_ejecutado())
                        .sum());
                BigDecimal sumaDescuentos = new BigDecimal((float) listaDescuentos.stream()
                        .mapToDouble(gasto -> (double) gasto.getValor_ejecutado())
                        .sum());


                String codigoEncontrado = codigosDAO.encontrarPosgradoPorCodigo(codigo.getCodigo()).getDescripcion();

                //Armar el consolidado
                ConsolidadoDTORes consolidado = new ConsolidadoDTORes();
                consolidado.setTotal_ingresos(sumaIngreso);
                consolidado.setTotal_descuentos(sumaDescuentos);
                consolidado.setTotal_neto(
                        sumaIngreso.subtract(sumaDescuentos));
                consolidado.setContribucion(consolidado.getTotal_neto().multiply(BigDecimal.valueOf(0.20f)));
                consolidado
                        .setTotal_disponible(consolidado.getTotal_neto()
                                .subtract(consolidado.getContribucion()));
                consolidado.setGastos_certificados(gastoTotal);
                consolidado
                        .setSaldo(consolidado.getTotal_disponible()
                                .subtract(consolidado.getGastos_certificados()));
                consolidado.setNombrePosgrado(codigoEncontrado);
                consolidado.setCodigoPosgrado(codigo.getCodigo());

                System.out.println(consolidado.getNombrePosgrado()+" "+consolidado.getSaldo());
                reporte.getConsolidados().add(consolidado);
            }
        }
        return reporte;
    }

    private java.sql.Date ajustarFecha(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new java.sql.Date(calendar.getTimeInMillis());
    }
}
