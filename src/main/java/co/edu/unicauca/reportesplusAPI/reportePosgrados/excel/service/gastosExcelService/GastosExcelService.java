package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.gastosExcelService;

import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;

public interface GastosExcelService {
    public void generarGastosExcel(Sheet sheet, Date fechaInicio, Date fechaFin, String codigo) throws SQLException;
}
