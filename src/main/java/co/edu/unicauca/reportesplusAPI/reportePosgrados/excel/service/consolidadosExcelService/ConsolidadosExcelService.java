package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.consolidadosExcelService;

import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;

public interface ConsolidadosExcelService {
    public void generarConsolidadosExcelService(Sheet sheet, Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException;
}
