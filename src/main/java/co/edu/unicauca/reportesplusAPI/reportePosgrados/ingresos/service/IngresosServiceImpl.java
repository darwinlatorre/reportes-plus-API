package co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO.IngresosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO.IngresosEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.mapper.IngresosMapper;

@Service
public class IngresosServiceImpl implements IngresosService {

    @Autowired
    private IngresosDAO DAO;
    @Autowired(required = true)
    private IngresosMapper ingresoMapper;
    @Autowired
    private CodigosDAO codigosDAO;

    @Override
    public List<IngresoDTORes> mapearIngresos() throws SQLException {
        List<IngresosEntity> ingresosSinMapear = DAO.findAllIncomeReport();

        return ingresosSinMapear
                .stream().map(ingresosEntity -> ingresoMapper.ingresoEntityToIngresoDTO(ingresosEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<List<IngresoDTORes>> mapearIngresosPorFechas(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {

        List<IngresosEntity> ingresosSinMapear = DAO.findAllIncomeReport();

        List<IngresoDTORes> listaIngresosPositivos = new ArrayList<>();
        List<IngresoDTORes> listaDescuentos = new ArrayList<>();

        for (IngresosEntity ingresosEntity : ingresosSinMapear) {
            Date fechaGasto = ingresosEntity.getFecha();
            String cuentaMovimiento = ingresosEntity.getCuenta_movimiento();
            String codigoTipo = cuentaMovimiento.substring(cuentaMovimiento.lastIndexOf(".") + 1);

            if (fechaGasto.before(fechaFin) && fechaGasto.after(fechaInicio) && codigoTipo.equals(codigo)) {
                IngresoDTORes ingresoDTO = ingresoMapper.ingresoEntityToIngresoDTO(ingresosEntity);
                if (ingresoDTO.getObservacion().contains("DESCUENTO")
                        || ingresoDTO.getObservacion().contains("DESCUENTOS")) {
                    listaDescuentos.add(ingresoDTO);
                } else {
                    listaIngresosPositivos.add(ingresoDTO);
                }
            }
        }

        List<List<IngresoDTORes>> resultado = new ArrayList<>();
        resultado.add(listaIngresosPositivos);
        resultado.add(listaDescuentos);

        return resultado;
    }

    public IngresosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {

        // crear el DTO
        IngresosDTORes reporte = new IngresosDTORes();

        // llamar al metodo mapearIngresos por fecha y sacar sus dos listas
        List<List<IngresoDTORes>> ingresosMapeados = mapearIngresosPorFechas(fechaInicio, fechaFin, codigo);
        List<IngresoDTORes> ingresos = ingresosMapeados.get(0);
        List<IngresoDTORes> descuentos = ingresosMapeados.get(1);

        // sacar la suma de los ingresos y la suma de los descuentos
        BigDecimal sumaIngreso = ingresos.stream()
                .map(ingreso -> ingreso.getValor_ejecutado())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal sumaDescuentos = descuentos.stream()
                .map(descuento -> descuento.getValor_ejecutado())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // set al DTO

        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.setCodigoPosgrado(codigo);
        reporte.setIngresos(ingresos);
        reporte.setDescuentos(descuentos);
        reporte.setTotal_ingresos(sumaIngreso);
        reporte.setTotal_descuentos(sumaDescuentos);
        reporte.setNombrePosgrado(codigosDAO.encontrarPosgradoPorCodigo(codigo).getDescripcion());

        return reporte;
    }
}
