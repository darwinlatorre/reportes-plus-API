package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.macroExcelService;

import java.sql.SQLException;
import java.util.Date;

public interface MacroExcelService {
    public byte[] generarReporteExcel(Date fechaInicio, Date fechaFin, String codigo) throws SQLException;
}
