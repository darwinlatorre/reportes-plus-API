package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.consolidadosExcelService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.sheetStyles.sheetStylerCells;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service.ConsolidadoService;

@Service
public class ConsolidadosExcelServiceImpl implements ConsolidadosExcelService {

    @Autowired
    ConsolidadoService ConsolidadoService;

    @Autowired
    sheetStylerCells sheetStylerCells;

    @Override
    public void generarConsolidadosExcelService(Sheet sheet, Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {
        ConsolidadoDTORes consolidadoDTORes = ConsolidadoService.generarConsolidado(fechaInicio, fechaFin, codigo);

        String[] headers = {
                "TOTAL SERVICIOS BASICOS",
                "TOTAL DESCUENTOS",
                "TOTAL RECAUDOS NETO",
                "CONTRIBUCIÓN DEL (-20 %)",
                "TOTAL DISPONIBLE",
                "GASTOS CERTIFICADOS",
                "SALDO A LA FECHA"
        };

        BigDecimal[] values = {
                consolidadoDTORes.getTotal_ingresos(),
                consolidadoDTORes.getTotal_descuentos(),
                consolidadoDTORes.getTotal_neto(),
                consolidadoDTORes.getContribucion(),
                consolidadoDTORes.getTotal_disponible(),
                consolidadoDTORes.getGastos_certificados(),
                consolidadoDTORes.getSaldo()
        };
        sheetStylerCells.setTituloConsolidado(sheet, "RELACIÓN DE RECAUDOS NETOS MENOS CERTIFICADOS DEL PROGRAMA DE "
                + consolidadoDTORes.getNombrePosgrado().toUpperCase(), 1, 2);

        CellStyle infoStyle = sheet.getWorkbook().createCellStyle();
        Map<Integer,String> colors= new TreeMap();
        colors.put(2,"B8CCE4");
        colors.put(4,"B8CCE4");
        colors.put(6,"7DB8B6");


        for (int i = 0; i < headers.length; i++) {
            Row row = sheet.createRow(i + 2);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(headers[i]);

            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            cellStyle.cloneStyleFrom(infoStyle);

            if (colors.containsKey(i)) {
                sheetStylerCells.setFgColor(colors.get(i), cellStyle);
            }

            cell0.setCellStyle(cellStyle);

            if (values[i] != null) {
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(values[i].toString());
                cell1.setCellStyle(cellStyle);
            }
        }
    }

}
