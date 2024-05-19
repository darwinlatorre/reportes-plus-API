package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.DTOs.MacroDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.service.MacroService;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@Service
public class MacroExcelService {

    @Autowired
    private MacroService reporteMacroService;

    public byte[] generarReporteExcel(Date fechaInicio, Date fechaFin, String codigo) throws SQLException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Reporte");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Código Posgrado");
        headerRow.createCell(1).setCellValue("Nombre Posgrado");
        headerRow.createCell(2).setCellValue("Total Ingresos");
        headerRow.createCell(3).setCellValue("Total Descuentos");
        headerRow.createCell(4).setCellValue("Total Neto");
        headerRow.createCell(5).setCellValue("Contribución");
        headerRow.createCell(6).setCellValue("Total Disponible");
        headerRow.createCell(7).setCellValue("Gastos Certificados");
        headerRow.createCell(8).setCellValue("Saldo");

        MacroDTORes reporte = reporteMacroService.generarReporteMacro(fechaInicio, fechaFin, codigo);

        XSSFCellStyle headerCellStyle = workbook.createCellStyle();
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);

        int rowNum = 1;
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
