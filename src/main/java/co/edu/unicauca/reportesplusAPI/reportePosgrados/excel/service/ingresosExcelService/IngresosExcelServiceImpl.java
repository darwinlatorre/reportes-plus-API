package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.ingresosExcelService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.service.IngresosService;

@Service
public class IngresosExcelServiceImpl implements IngresosExcelService {

    @Autowired
    IngresosService IngresosService;

    @Override
    public void generarIngresosExcel(Sheet ingresoSheet, Sheet descuentoSheet, Date fechaInicio, Date fechaFin,
            String codigo) throws SQLException {
        IngresosDTORes ingresosDTORes = IngresosService.generarReporte(fechaInicio, fechaFin, codigo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);

        String informacionReporte = ingresosDTORes.getNombrePosgrado().toUpperCase() + " DE " + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;

        Row beforeHeaderRow = ingresoSheet.createRow(1);
        beforeHeaderRow.createCell(0).setCellValue(informacionReporte);

        String[] sheetColumns = { "Tipo Dcto", "Numero", "Fecha", "Cuenta de Movimiento", "Tercero",
                "Nombre Tercero", "Observaccion", "Valor Ejecutado" };
        Row headerRow = ingresoSheet.createRow(3);

        for (int index = 0; index < sheetColumns.length; index++) {
            Cell cell = headerRow.createCell(index);
            cell.setCellValue(sheetColumns[index]);
        }
        List<IngresoDTORes> ListIngresos = ingresosDTORes.getIngresos();
        int rowIndex = 4;
        for (IngresoDTORes ingresoDTORes : ListIngresos) {
            Row ValuesSheetRow = ingresoSheet.createRow(rowIndex++);
            ValuesSheetRow.createCell(0).setCellValue(ingresoDTORes.getTipo_documento());
            ValuesSheetRow.createCell(1).setCellValue(ingresoDTORes.getNumero_movimiento());
            ValuesSheetRow.createCell(2).setCellValue(ingresoDTORes.getFecha());
            ValuesSheetRow.createCell(3).setCellValue(ingresoDTORes.getCuenta_movimiento());
            ValuesSheetRow.createCell(4).setCellValue(ingresoDTORes.getId_tercero().toString());
            ValuesSheetRow.createCell(5).setCellValue(ingresoDTORes.getNombre_tercero());
            ValuesSheetRow.createCell(6).setCellValue(ingresoDTORes.getObservacion());
            ValuesSheetRow.createCell(7).setCellValue(ingresoDTORes.getValor_ejecutado().toString());
        }
        Row endSheetRow = ingresoSheet.createRow(rowIndex);
        endSheetRow.createCell(6).setCellValue("TOTAL SERVICIOS BASICOS");
        endSheetRow.createCell(7).setCellValue(ingresosDTORes.getTotal_ingresos().toString());

        generarDescuentosExcel(ingresosDTORes, descuentoSheet, fechaInicio, fechaFin, codigo);
    }

    public void generarDescuentosExcel(IngresosDTORes ingresosDTORes, Sheet descuentoSheet, Date fechaInicio,
            Date fechaFin, String codigo) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);

        String informacionReporte = ingresosDTORes.getNombrePosgrado().toUpperCase() + " DE " + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;

        Row beforeHeaderRow = descuentoSheet.createRow(1);
        beforeHeaderRow.createCell(0).setCellValue(informacionReporte);

        String[] sheetColumns = { "Tipo Dcto", "Numero", "Fecha", "Cuenta de Movimiento", "Tercero",
                "Nombre Tercero", "Observaccion", "Valor Ejecutado" };
        Row headerRow = descuentoSheet.createRow(3);

        for (int index = 0; index < sheetColumns.length; index++) {
            Cell cell = headerRow.createCell(index);
            cell.setCellValue(sheetColumns[index]);
        }

        List<IngresoDTORes> listDescuentos = ingresosDTORes.getDescuentos();
        int rowIndex = 4;
        for (IngresoDTORes descuentoDTORes : listDescuentos) {
            Row ValuesSheetRow = descuentoSheet.createRow(rowIndex++);
            ValuesSheetRow.createCell(0).setCellValue(descuentoDTORes.getTipo_documento());
            ValuesSheetRow.createCell(1).setCellValue(descuentoDTORes.getNumero_movimiento());
            ValuesSheetRow.createCell(2).setCellValue(descuentoDTORes.getFecha());
            ValuesSheetRow.createCell(3).setCellValue(descuentoDTORes.getCuenta_movimiento());
            ValuesSheetRow.createCell(4).setCellValue(descuentoDTORes.getId_tercero().toString());
            ValuesSheetRow.createCell(5).setCellValue(descuentoDTORes.getNombre_tercero());
            ValuesSheetRow.createCell(6).setCellValue(descuentoDTORes.getObservacion());
            ValuesSheetRow.createCell(7).setCellValue(descuentoDTORes.getValor_ejecutado().toString());
        }
        Row endSheetRow = descuentoSheet.createRow(rowIndex);
        endSheetRow.createCell(6).setCellValue("TOTAL DESCUENTOS");
        endSheetRow.createCell(7).setCellValue(ingresosDTORes.getTotal_descuentos().toString());

    }
}
