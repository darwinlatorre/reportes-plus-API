package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.DAO.CodigosPosgrados.CodigosPosgradosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.CodigosPosgrados.CodigosPosgradosEntity;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.ReporteIngresosPosDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteIngresosPosServiceImpl implements ReporteIngresosPosService{

    @Autowired
    private ReporteIngresosPosDAO DAO;
    @Autowired
    private ReporteIngresosPosMapper ingresoMapper;
    @Autowired
    private CodigosPosgradosDAO DAOCodigosPosgrados;

    @Override
    public List<IngresoDTORes> mapearIngresos() throws SQLException {
        List<ReporteIngresosPosEntity> ingresosSinMapear=DAO.findAllIncomeReport();

        return ingresosSinMapear
                .stream().map(ingresosEntity -> ingresoMapper.ingresoEntityToIngresoDTO(ingresosEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<List<IngresoDTORes>> mapearIngresosPorFechas(Date fechaInicio, Date fechaFin, String codigo) throws SQLException {

        List<ReporteIngresosPosEntity> ingresosSinMapear = DAO.findAllIncomeReport();

        List<IngresoDTORes> listaIngresosPositivos = new ArrayList<>();
        List<IngresoDTORes> listaDescuentos = new ArrayList<>();

        for (ReporteIngresosPosEntity ingresosEntity : ingresosSinMapear) {
            Date fechaGasto = ingresosEntity.getFecha();
            String cuentaMovimiento = ingresosEntity.getCuenta_movimiento();
            String codigoTipo = cuentaMovimiento.substring(cuentaMovimiento.lastIndexOf(".") + 1);

            if (fechaGasto.before(fechaFin) && fechaGasto.after(fechaInicio) && codigoTipo.equals(codigo)) {
                IngresoDTORes ingresoDTO = ingresoMapper.ingresoEntityToIngresoDTO(ingresosEntity);
                double valorEjecutado = ingresosEntity.getValor_ejecutado().doubleValue(); // Convertir a double
                if (valorEjecutado < 0) {
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

    public ReporteIngresosPosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo) throws SQLException{

        //crear el DTO
        ReporteIngresosPosDTORes reporte = new ReporteIngresosPosDTORes();

        //llamar al metodo mapearIngresos por fecha y sacar sus dos listas
        List<List<IngresoDTORes>> ingresosMapeados = mapearIngresosPorFechas(fechaInicio, fechaFin, codigo);
        List<IngresoDTORes> ingresos = ingresosMapeados.get(0);
        List<IngresoDTORes> descuentos = ingresosMapeados.get(1);

        //sacar la suma de los ingresos y la suma de los descuentos
        float sumaIngreso = (float) ingresos.stream()
                .mapToDouble(gasto -> (double) gasto.getValor_ejecutado())
                .sum();
        float sumaDescuentos = (float) descuentos.stream()
                .mapToDouble(gasto -> (double) gasto.getValor_ejecutado())
                .sum();

        //set al DTO

        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.setCodigoPosgrado(codigo);
        reporte.setIngresos(ingresos);
        reporte.setDescuentos(descuentos);
        reporte.setTotal_ingresos(sumaIngreso);
        reporte.setTotal_descuentos(sumaDescuentos);

        for(CodigosPosgradosEntity entity:DAOCodigosPosgrados.findAllCodes())
        {
            if(entity.getCodigo().equals(codigo))
            {
                reporte.setNombrePosgrado(entity.getDescripcion());
            }
        }

        return reporte;
    }
}
