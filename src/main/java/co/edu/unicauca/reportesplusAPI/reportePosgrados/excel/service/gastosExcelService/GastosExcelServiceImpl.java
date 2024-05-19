package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.gastosExcelService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.ResumenGastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service.GastosService;

@Service
public class GastosExcelServiceImpl implements GastosExcelService {
    @Autowired
    GastosService GastosService;

    @Override
    public void generarGastosExcel(Sheet sheet, Date fechaInicio, Date fechaFin, String codigo) throws SQLException {

        ResumenGastosDTORes ResumenGastos = GastosService.generarReporte(fechaInicio, fechaFin, codigo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String fechaInicioFormateada = dateFormat.format(fechaInicio);
        String fechaFinFormateada = dateFormat.format(fechaFin);

        String informacionReporte = ResumenGastos.getNombrePosgrado().toUpperCase() + " DE " + fechaInicioFormateada
                + " A "
                + fechaFinFormateada;

        Row beforeHeaderRow = sheet.createRow(1);
        beforeHeaderRow.createCell(0).setCellValue(informacionReporte);

        String[] sheetColumns = { "Tipo Dcto", "Numero", "Fecha", "Observacion", "Valor Definitivo",
                "Valor Registros", "Valor Ejecutado", "Valor Pagado", "Saldo", "Estado" };
        Row headerRow = sheet.createRow(3);

        for (int index = 0; index < sheetColumns.length; index++) {
            Cell cell = headerRow.createCell(index);
            cell.setCellValue(sheetColumns[index]);
        }
        List<GastoDTORes> listGastos = ResumenGastos.getListaGastos();

        int rowIndex = 4;
        for (GastoDTORes gastoDTORes : listGastos) {
            Row ValuesSheetRow = sheet.createRow(rowIndex++);
            ValuesSheetRow.createCell(0).setCellValue(gastoDTORes.getTipo_documento());
            ValuesSheetRow.createCell(1).setCellValue(gastoDTORes.getNumero_movimiento());
            ValuesSheetRow.createCell(2).setCellValue(gastoDTORes.getFecha());
            ValuesSheetRow.createCell(3).setCellValue(gastoDTORes.getCuenta_movimiento());
            ValuesSheetRow.createCell(4).setCellValue(gastoDTORes.getObservacion());
            ValuesSheetRow.createCell(5).setCellValue(gastoDTORes.getValor_definitivo().toString());
            ValuesSheetRow.createCell(6).setCellValue(gastoDTORes.getValor_registro().toString());
            ValuesSheetRow.createCell(7).setCellValue(gastoDTORes.getValor_ejecutado().toString());
            ValuesSheetRow.createCell(8).setCellValue(gastoDTORes.getValor_pagado().toString());
            ValuesSheetRow.createCell(9).setCellValue(gastoDTORes.getSaldo().toString());
            ValuesSheetRow.createCell(10).setCellValue(gastoDTORes.getEstado());
        }
        Row endSheetRow = sheet.createRow(rowIndex);
        endSheetRow.createCell(4).setCellValue("TOTAL GASTOS REC 901");
        endSheetRow.createCell(5).setCellValue(ResumenGastos.getSumaValorDefinitivo().toString());
        endSheetRow.createCell(6).setCellValue(ResumenGastos.getSumaValorRegistros().toString());
        endSheetRow.createCell(7).setCellValue(ResumenGastos.getSumaValorEjecutado().toString());
        endSheetRow.createCell(8).setCellValue(ResumenGastos.getSumaValorPagado().toString());
        endSheetRow.createCell(9).setCellValue(ResumenGastos.getSumaValorPagado().toString());
    }
}
