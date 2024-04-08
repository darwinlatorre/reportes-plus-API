package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface ReporteGastosPosService {
    public List<GastoDTORes> mapearGastos() throws SQLException;

    List<GastoDTORes> mapearGastosPorFechas(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;

    public ReportesGastosPosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)  throws SQLException;
}
