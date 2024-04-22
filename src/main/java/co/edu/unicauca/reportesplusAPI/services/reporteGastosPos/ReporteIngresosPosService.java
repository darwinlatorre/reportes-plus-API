package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.ReporteIngresosPosDTORes;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ReporteIngresosPosService {
    public List<IngresoDTORes> mapearIngresos() throws SQLException;


    List<List<IngresoDTORes>> mapearIngresosPorFechas(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;

    public ReporteIngresosPosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;
}
