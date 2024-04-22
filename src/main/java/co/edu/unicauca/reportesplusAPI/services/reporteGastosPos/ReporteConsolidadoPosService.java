package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.dtos.reporteConsolidado.ConsolidadoDTORes;

import java.sql.SQLException;
import java.util.Date;

public interface ReporteConsolidadoPosService {

    public ConsolidadoDTORes generarConsolidado(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;
}
