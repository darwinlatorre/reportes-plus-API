package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.consolidadosExcelService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service.ConsolidadoService;

@Service
public class ConsolidadosExcelServiceImpl implements ConsolidadosExcelService {

    @Autowired
    ConsolidadoService ConsolidadoService;

    @Override
    public void generarConsolidadosExcelService(Sheet sheet, Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {
        ConsolidadoDTORes consolidadoDTORes = ConsolidadoService.generarConsolidado(fechaInicio, fechaFin, codigo);

        String[] headers = {
                "RELACIÓN DE RECAUDOS NETOS MENOS CERTIFICADOS DEL PROGRAMA DE "
                        + consolidadoDTORes.getNombrePosgrado().toUpperCase(),
                "TOTAL SERVICIOS BASICOS",
                "TOTAL DESCUENTOS",
                "TOTAL RECAUDOS NETO",
                "CONTRIBUCIÓN DEL (-20 %)",
                "TOTAL DISPONIBLE",
                "GASTOS CERTIFICADOS",
                "SALDO A LA FECHA"
        };

        BigDecimal[] values = {
                null,
                consolidadoDTORes.getTotal_ingresos(),
                consolidadoDTORes.getTotal_descuentos(),
                consolidadoDTORes.getTotal_neto(),
                consolidadoDTORes.getContribucion(),
                consolidadoDTORes.getTotal_disponible(),
                consolidadoDTORes.getGastos_certificados(),
                consolidadoDTORes.getSaldo()
        };

        for (int i = 0; i < headers.length; i++) {

            Row row = sheet.createRow(i + 1);
            Cell cell0 = row.createCell(1);
            cell0.setCellValue(headers[i]);

            if (values[i] != null) {
                Cell cell1 = row.createCell(2);
                cell1.setCellValue(values[i].toString());
            }
        }
    }

}
