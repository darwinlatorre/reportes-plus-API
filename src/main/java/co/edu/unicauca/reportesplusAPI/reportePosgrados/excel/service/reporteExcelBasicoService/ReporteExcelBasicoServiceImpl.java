package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.reporteExcelBasicoService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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

            Font font = workbook.createFont();
            font.setFontName("Calibri");

            CellStyle style = workbook.createCellStyle();
            style.setFont(font);

            Sheet ingresSheet = workbook.createSheet("INGRESOS");
            getStyleToSheet(style, ingresSheet);
            Sheet descuentosSheet = workbook.createSheet("DESCUENTOS");
            getStyleToSheet(style, descuentosSheet);
            IngresosExcelService.generarIngresosExcel(ingresSheet, descuentosSheet, fechaInicio, fechaFin, codigo);

            Sheet consolidadosSheet = workbook.createSheet("CONSOLIDADOS");
            getStyleToSheet(style, consolidadosSheet);
            ConsolidadosExcelService.generarConsolidadosExcelService(consolidadosSheet, fechaInicio, fechaFin, codigo);

            Sheet gastosSheet = workbook.createSheet("GASTOS");
            getStyleToSheet(style, gastosSheet);
            GastosExcelService.generarGastosExcel(gastosSheet, fechaInicio, fechaFin, codigo);

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    private void getStyleToSheet(CellStyle style, Sheet sheet) {
        org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol cTCol = ((XSSFSheet) sheet).getCTWorksheet()
                .getColsArray(0).addNewCol();
        cTCol.setMin(1);
        cTCol.setMax(16384);
        cTCol.setWidth(12.7109375);
        cTCol.setStyle(style.getIndex());
    }
}
