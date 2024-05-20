package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.macroExcelService;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.sheetStyles.sheetStylerCells;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.DTOs.MacroDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.service.MacroService;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MacroExcelServiceImpl implements MacroExcelService {

    @Autowired
    private MacroService reporteMacroService;

    @Autowired
    sheetStylerCells sheetStylerCells;
    @Override
    public byte[] generarReporteExcel(Date fechaInicio, Date fechaFin, String codigo) throws SQLException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Reporte");

        MacroDTORes reporte = reporteMacroService.generarReporteMacro(fechaInicio, fechaFin, codigo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);


        String informacionReporte = "Reporte Macro DE "
                + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;

        sheetStylerCells.setStyleInfoSheet(sheet, informacionReporte, 0, 9);

        String[] sheetColumns = { "Código Posgrado", "Nombre Posgrado", "Total Ingresos",
                "Total Descuentos","Total Neto","Contribución","Total Disponible","Gastos Certificados","Saldo" };

       
        int[] columnWidths = { 10 * 256, 50 * 256,12 * 256, 12 * 256, 12 * 256,12 * 256, 12 * 256, 12 * 256,
            12 * 256};

        sheetStylerCells.setHeaderIngresosDescuentosStyle(sheet, sheetColumns, columnWidths, "#A5A5A5");




        int rowNum = 4;
        for (ConsolidadoDTORes consolidado : reporte.getConsolidados()) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(consolidado.getCodigoPosgrado());
            row.createCell(1).setCellValue(consolidado.getNombrePosgrado());
            row.createCell(2).setCellValue(consolidado.getTotal_ingresos().doubleValue());
            row.createCell(3).setCellValue(consolidado.getTotal_descuentos().doubleValue());
            row.createCell(4).setCellValue(consolidado.getTotal_neto().doubleValue());
            row.createCell(5).setCellValue(consolidado.getContribucion().doubleValue());
            row.createCell(6).setCellValue(consolidado.getTotal_disponible().doubleValue());
            row.createCell(7).setCellValue(consolidado.getGastos_certificados().doubleValue());
            row.createCell(8).setCellValue(consolidado.getSaldo().doubleValue());
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
