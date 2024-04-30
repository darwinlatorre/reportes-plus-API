package co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service;

import java.sql.SQLException;
import java.util.Date;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;

public interface ConsolidadoService {

    public ConsolidadoDTORes generarConsolidado(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException;
}
