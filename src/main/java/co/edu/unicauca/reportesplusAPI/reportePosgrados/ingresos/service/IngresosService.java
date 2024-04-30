package co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresosDTORes;

public interface IngresosService {
        public List<IngresoDTORes> mapearIngresos() throws SQLException;

        List<List<IngresoDTORes>> mapearIngresosPorFechas(Date fechaInicio, Date fechaFin, String codigo)
                        throws SQLException;

        public IngresosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
                        throws SQLException;
}
