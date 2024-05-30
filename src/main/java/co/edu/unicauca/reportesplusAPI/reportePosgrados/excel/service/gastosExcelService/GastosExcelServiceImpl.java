package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.gastosExcelService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.sheetStyles.sheetStylerCells;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.ResumenGastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service.GastosService;

@Service
public class GastosExcelServiceImpl implements GastosExcelService {

    @Autowired
    GastosService GastosService;

    @Autowired
    sheetStylerCells sheetStylerCells;

    @Override
    public void generarGastosExcel(Sheet sheet, Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {

        ResumenGastosDTORes ResumenGastos = GastosService.generarReporte(fechaInicio, fechaFin, codigo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);

        String informacionReporte = ResumenGastos.getNombrePosgrado().toUpperCase() + " DE "
                + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;

        sheetStylerCells.setStyleInfoSheet(sheet, informacionReporte, 0, 10);

        String[] sheetColumns = { "Tipo Dcto", "Numero", "Fecha", "Cuenta de Movimiento", "Observacion",
                "Valor Definitivo",
                "Valor Registros", "Valor Ejecutado", "Valor Pagado", "Saldo", "Estado" };

        // Cada valor en el arreglo columnWidths representa el ancho deseado de la
        // columna correspondiente en unidades de 1/256 de un carácter (el ancho
        // predeterminado de una columna es de 8 caracteres). Puedes ajustar estos
        // valores según tus necesidades específicas
        int[] columnWidths = { 6 * 256, 12 * 256, 20 * 256, 35 * 256, 70 * 256, 18 * 256, 18 * 256, 18 * 256,
                18 * 256,
                18 * 256, 8 * 256 };

        sheetStylerCells.setHeaderIngresosDescuentosStyle(sheet, sheetColumns, columnWidths, "#A5A5A5");

        List<GastoDTORes> listGastos = ResumenGastos.getListaGastos();

        int rowIndex = 4;
        for (GastoDTORes gastoDTORes : listGastos) {
            Row ValuesSheetRow = sheet.createRow(rowIndex++);
            ValuesSheetRow.createCell(0).setCellValue(gastoDTORes.getTipo_documento());
            ValuesSheetRow.createCell(1).setCellValue(gastoDTORes.getNumero_movimiento());

            Cell Fecha = ValuesSheetRow.createCell(2);
            sheetStylerCells.setCellDateFormat(Fecha, gastoDTORes.getFecha());

            ValuesSheetRow.createCell(3).setCellValue(gastoDTORes.getCuenta_movimiento());
            ValuesSheetRow.createCell(4).setCellValue(gastoDTORes.getObservacion());

            Cell varlorDefinitivo = ValuesSheetRow.createCell(5);
            sheetStylerCells.setCellCurrencyStyle(varlorDefinitivo, gastoDTORes.getValor_definitivo(),
                    IndexedColors.BLACK, false, null);

            Cell valorRegistro = ValuesSheetRow.createCell(6);
            sheetStylerCells.setCellCurrencyStyle(valorRegistro, gastoDTORes.getValor_registro(),
                    IndexedColors.BLACK, false, null);

            Cell valorEjecutado = ValuesSheetRow.createCell(7);
            sheetStylerCells.setCellCurrencyStyle(valorEjecutado, gastoDTORes.getValor_ejecutado(),
                    IndexedColors.BLACK, false, null);

            Cell valorPagado = ValuesSheetRow.createCell(8);
            sheetStylerCells.setCellCurrencyStyle(valorPagado, gastoDTORes.getValor_pagado(),
                    IndexedColors.BLACK, false, null);

            Cell valorSaldo = ValuesSheetRow.createCell(9);
            sheetStylerCells.setCellCurrencyStyle(valorSaldo, gastoDTORes.getSaldo(),
                    IndexedColors.BLACK, false, null);

            ValuesSheetRow.createCell(10).setCellValue(gastoDTORes.getEstado());
        }
        Row endSheetRow = sheet.createRow(rowIndex);
        sheetStylerCells.setCellStringStyle(endSheetRow.createCell(4), "TOTAL GASTOS REC 901", null, false,
                null);

        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(5), ResumenGastos.getSumaValorDefinitivo(),
                null,
                true, null);
        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(6), ResumenGastos.getSumaValorRegistros(),
                null,
                true, null);
        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(7), ResumenGastos.getSumaValorEjecutado(),
                null,
                true, null);
        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(8), ResumenGastos.getSumaValorPagado(),
                null,
                true, null);
        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(9), ResumenGastos.getSumaValorPagado(),
                null,
                true, null);
        ;
    }
}
