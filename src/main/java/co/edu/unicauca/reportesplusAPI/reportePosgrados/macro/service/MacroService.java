package co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.service;

import java.sql.SQLException;
import java.util.Date;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.DTOs.MacroDTORes;

public interface MacroService {
    public MacroDTORes generarReporteMacro(Date fechaInicio, Date fechaFin, String fragmentoCodigo)
            throws SQLException;
}
