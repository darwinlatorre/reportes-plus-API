package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.ReporteIngresosPosDTORes;

public interface ReporteIngresosPosService {
    public List<IngresoDTORes> mapearIngresos() throws SQLException;

    List<List<IngresoDTORes>> mapearIngresosPorFechas(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException;

    public ReporteIngresosPosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;
}
