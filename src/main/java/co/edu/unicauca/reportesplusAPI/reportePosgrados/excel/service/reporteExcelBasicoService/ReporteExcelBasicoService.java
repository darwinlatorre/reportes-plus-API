package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.reporteExcelBasicoService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public interface ReporteExcelBasicoService {
    public byte[] generarIngresosGastosExcel(Date fechaInicio, Date fechaFin, String codigo)
            throws IOException, SQLException;
}
