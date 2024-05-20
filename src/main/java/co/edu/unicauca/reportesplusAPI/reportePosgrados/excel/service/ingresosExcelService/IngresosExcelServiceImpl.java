package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.ingresosExcelService;

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
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.service.IngresosService;

@Service
public class IngresosExcelServiceImpl implements IngresosExcelService {

    @Autowired
    IngresosService IngresosService;

    @Autowired
    sheetStylerCells sheetStylerCells;

    @Override
    public void generarIngresosExcel(Sheet ingresoSheet, Sheet descuentoSheet, Date fechaInicio, Date fechaFin,
            String codigo) throws SQLException {
        IngresosDTORes ingresosDTORes = IngresosService.generarReporte(fechaInicio, fechaFin, codigo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);

        String informacionReporte = ingresosDTORes.getNombrePosgrado().toUpperCase() + " DE "
                + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;
        sheetStylerCells.setStyleInfoSheet(ingresoSheet, informacionReporte, 0, 7);

        String[] sheetColumns = { "Tipo Dcto", "Numero", "Fecha", "Cuenta de Movimiento", "Tercero",
                "Nombre Tercero", "Observaccion", "Valor Ejecutado" };
        // Cada valor en el arreglo columnWidths representa el ancho deseado de la
        // columna correspondiente en unidades de 1/256 de un carácter (el ancho
        // predeterminado de una columna es de 8 caracteres). Puedes ajustar estos
        // valores según tus necesidades específicas
        int[] columnWidths = { 6 * 256, 12 * 256, 20 * 256, 35 * 256, 12 * 256, 35 * 256, 50 * 256, 18 * 256 };

        sheetStylerCells.setHeaderIngresosDescuentosStyle(ingresoSheet, sheetColumns, columnWidths, "#C4D79B");

        List<IngresoDTORes> ListIngresos = ingresosDTORes.getIngresos();
        int rowIndex = 4;

        for (IngresoDTORes ingresoDTORes : ListIngresos) {
            Row ValuesSheetRow = ingresoSheet.createRow(rowIndex++);
            ValuesSheetRow.createCell(0).setCellValue(ingresoDTORes.getTipo_documento());
            ValuesSheetRow.createCell(1).setCellValue(ingresoDTORes.getNumero_movimiento());

            Cell Fecha = ValuesSheetRow.createCell(2);
            sheetStylerCells.setCellDateFormat(Fecha, ingresoDTORes.getFecha());

            ValuesSheetRow.createCell(3).setCellValue(ingresoDTORes.getCuenta_movimiento());
            ValuesSheetRow.createCell(4).setCellValue(ingresoDTORes.getId_tercero().toString());
            ValuesSheetRow.createCell(5).setCellValue(ingresoDTORes.getNombre_tercero());
            ValuesSheetRow.createCell(6).setCellValue(ingresoDTORes.getObservacion());

            Cell ValorEjecutado = ValuesSheetRow.createCell(7);
            sheetStylerCells.setCellCurrencyStyle(ValorEjecutado, ingresoDTORes.getValor_ejecutado(),
                    IndexedColors.RED, false, null);
        }

        Row endSheetRow = ingresoSheet.createRow(rowIndex);

        sheetStylerCells.setCellStringStyle(endSheetRow.createCell(6), "TOTAL SERVICIOS BASICOS", null, false,
                "#C4D79B");

        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(7), ingresosDTORes.getTotal_ingresos(),
                null,
                true, "#C4D79B");

        generarDescuentosExcel(ingresosDTORes, descuentoSheet, fechaInicio, fechaFin, codigo);
    }

    public void generarDescuentosExcel(IngresosDTORes ingresosDTORes, Sheet descuentoSheet, Date fechaInicio,
            Date fechaFin, String codigo) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);

        String informacionReporte = ingresosDTORes.getNombrePosgrado().toUpperCase() + " DE "
                + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;

        sheetStylerCells.setStyleInfoSheet(descuentoSheet, informacionReporte, 0, 7);

        String[] sheetColumns = { "Tipo Dcto", "Numero", "Fecha", "Cuenta de Movimiento", "Tercero",
                "Nombre Tercero", "Observaccion", "Valor Ejecutado" };
        // Cada valor en el arreglo columnWidths representa el ancho deseado de la
        // columna correspondiente en unidades de 1/256 de un carácter (el ancho
        // predeterminado de una columna es de 8 caracteres). Puedes ajustar estos
        // valores según tus necesidades específicas
        int[] columnWidths = { 6 * 256, 12 * 256, 20 * 256, 35 * 256, 12 * 256, 35 * 256, 50 * 256, 18 * 256 };

        sheetStylerCells.setHeaderIngresosDescuentosStyle(descuentoSheet, sheetColumns, columnWidths,
                "#DA9694");

        List<IngresoDTORes> listDescuentos = ingresosDTORes.getDescuentos();
        int rowIndex = 4;
        for (IngresoDTORes descuentoDTORes : listDescuentos) {
            Row ValuesSheetRow = descuentoSheet.createRow(rowIndex++);
            ValuesSheetRow.createCell(0).setCellValue(descuentoDTORes.getTipo_documento());
            ValuesSheetRow.createCell(1).setCellValue(descuentoDTORes.getNumero_movimiento());

            Cell Fecha = ValuesSheetRow.createCell(2);
            sheetStylerCells.setCellDateFormat(Fecha, descuentoDTORes.getFecha());

            ValuesSheetRow.createCell(3).setCellValue(descuentoDTORes.getCuenta_movimiento());
            ValuesSheetRow.createCell(4).setCellValue(descuentoDTORes.getId_tercero().toString());
            ValuesSheetRow.createCell(5).setCellValue(descuentoDTORes.getNombre_tercero());
            ValuesSheetRow.createCell(6).setCellValue(descuentoDTORes.getObservacion());

            Cell ValorEjecutado = ValuesSheetRow.createCell(7);
            sheetStylerCells.setCellCurrencyStyle(ValorEjecutado, descuentoDTORes.getValor_ejecutado(),
                    IndexedColors.RED, false, null);
        }
        Row endSheetRow = descuentoSheet.createRow(rowIndex);
        sheetStylerCells.setCellStringStyle(endSheetRow.createCell(6), "TOTAL DESCUENTOS", null, false,
                "#DA9694");

        sheetStylerCells.setCellCurrencyStyle(endSheetRow.createCell(7), ingresosDTORes.getTotal_descuentos(),
                null,
                true, "#DA9694");

    }

}
