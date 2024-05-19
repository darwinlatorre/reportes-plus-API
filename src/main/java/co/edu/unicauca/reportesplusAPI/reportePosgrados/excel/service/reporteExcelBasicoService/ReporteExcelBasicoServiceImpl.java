package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.reporteExcelBasicoService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.consolidadosExcelService.ConsolidadosExcelService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.gastosExcelService.GastosExcelService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.ingresosExcelService.IngresosExcelService;

@Service
public class ReporteExcelBasicoServiceImpl implements ReporteExcelBasicoService {

    @Autowired
    private IngresosExcelService IngresosExcelService;

    @Autowired
    private GastosExcelService GastosExcelService;

    @Autowired
    private ConsolidadosExcelService ConsolidadosExcelService;

    public byte[] generarIngresosGastosExcel(Date fechaInicio, Date fechaFin, String codigo)
            throws IOException, SQLException {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            Sheet ingresSheet = workbook.createSheet("INGRESOS");
            Sheet descuentosSheet = workbook.createSheet("DESCUENTOS");
            IngresosExcelService.generarIngresosExcel(ingresSheet, descuentosSheet, fechaInicio, fechaFin, codigo);
            Sheet gastosSheet = workbook.createSheet("GASTOS");
            GastosExcelService.generarGastosExcel(gastosSheet, fechaInicio, fechaFin, codigo);
            Sheet consolidadosSheet = workbook.createSheet("CONSOLIDADOS");
            ConsolidadosExcelService.generarConsolidadosExcelService(consolidadosSheet, fechaInicio, fechaFin, codigo);

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
