package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service;

import java.sql.SQLException;
import java.util.Date;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastosDTORes;

public interface GastosService {
    public GastosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException;
}
