package co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.DTOs.ReporteMacroDTORes;

import java.sql.SQLException;
import java.util.Date;

public interface ReporteMacroService {
    public ReporteMacroDTORes generarReporteMacro(Date fechaInicio, Date fechaFin, String fragmentoCodigo) throws SQLException;
}
