package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastosDTORes;

public interface GastosService {
    public List<GastoDTORes> mapearGastos() throws SQLException;

    List<GastoDTORes> mapearGastosPorFechas(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;

    public GastosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException;
}
