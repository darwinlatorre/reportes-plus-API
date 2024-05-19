
package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.ingresosExcelService;

import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;

public interface IngresosExcelService {
    public void generarIngresosExcel(Sheet sheetIngresos, Sheet sheetDesucentos, Date fechaInicio, Date fechaFin,
            String codigo) throws SQLException;
}