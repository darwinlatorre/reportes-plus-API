package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.sheetStyles;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.stereotype.Component;

@Component
public class sheetStylerCells {

    public void setStyleInfoSheet(Sheet sheet, String informacionReporte, int startRow, int endRow) {
        Row beforeHeaderRow = sheet.createRow(1);

        Cell infoCell = beforeHeaderRow.createCell(0);
        infoCell.setCellValue(informacionReporte);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, startRow, endRow));

        CellStyle infoStyle = sheet.getWorkbook().createCellStyle();
        infoStyle.setAlignment(HorizontalAlignment.CENTER);
        infoStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Font infoFont = sheet.getWorkbook().createFont();
        infoFont.setBold(true);
        infoStyle.setFont(infoFont);
        infoCell.setCellStyle(infoStyle);
    }

    public void setHeaderIngresosDescuentosStyle(Sheet sheet, String[] sheetStringColumns,
            int[] columnWidths,
            String HexForegroundColor) {
        Row headerRow = sheet.createRow(3);

        short HeightRow = 600;
        headerRow.setHeight(HeightRow);

        CellStyle headerStyle = sheet.getWorkbook().createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        headerStyle.setBorderBottom(BorderStyle.DOUBLE);
        headerStyle.setBorderTop(BorderStyle.DOUBLE);
        headerStyle.setBorderLeft(BorderStyle.DOUBLE);
        headerStyle.setBorderRight(BorderStyle.DOUBLE);

        setFgColor(HexForegroundColor, headerStyle);

        Font headerFont = sheet.getWorkbook().createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        headerStyle.setFont(headerFont);
        headerStyle.setWrapText(true);

        for (int index = 0; index < sheetStringColumns.length; index++) {
            Cell cell = headerRow.createCell(index);
            cell.setCellValue(sheetStringColumns[index]);
            cell.setCellStyle(headerStyle);

            if (index < columnWidths.length && columnWidths[index] >= 0) {
                sheet.setColumnWidth(index, columnWidths[index]);
            }
        }
    }

    private void setFgColor(String HexForegroundColor, CellStyle cellStyle) {
        if (HexForegroundColor != null && !HexForegroundColor.isEmpty()) {
            Color Color = hexToColor(HexForegroundColor);
            XSSFColor bgColor = new XSSFColor(Color, null);
            cellStyle.setFillForegroundColor(bgColor);
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
    }

    public void setCellCurrencyStyle(Cell cell, BigDecimal value, IndexedColors fontColor, boolean isBold,
            String HexForegroundColor) {

        cell.setCellValue(value.doubleValue());
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();

        setFgColor(HexForegroundColor, cellStyle);

        Font cellFontStyle = workbook.createFont();

        if (fontColor != null) {
            cellFontStyle.setColor(fontColor.getIndex());
        }
        cellFontStyle.setBold(isBold);
        cellStyle.setFont(cellFontStyle);
        cellStyle.setDataFormat((short) 8);

        cell.setCellStyle(cellStyle);

    }

    public void setCellStringStyle(Cell cell, String value, IndexedColors fontColor, boolean isBold,
            String HexForegroundColor) {

        cell.setCellValue(value);
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();

        setFgColor(HexForegroundColor, cellStyle);

        Font cellFontStyle = workbook.createFont();

        if (fontColor != null) {
            cellFontStyle.setColor(fontColor.getIndex());
        }
        cellFontStyle.setBold(isBold);
        cellStyle.setFont(cellFontStyle);

        cell.setCellStyle(cellStyle);

    }

    public void setCellDateFormat(Cell cell, Date dateValue) {
        cell.setCellValue(dateValue);
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat((short) 14);
        cell.setCellStyle(cellStyle);
    }

    public Color hexToColor(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }

        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        return new Color(r, g, b);
    }
}
