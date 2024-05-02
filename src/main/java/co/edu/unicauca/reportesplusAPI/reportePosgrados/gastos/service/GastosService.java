package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service;

import java.sql.SQLException;
import java.util.Date;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.ResumenGastosDTORes;

public interface GastosService {
    public ResumenGastosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException;
}
