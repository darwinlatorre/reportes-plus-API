package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.MacroExcelService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.reporteExcelBasicoService.ReporteExcelBasicoService;

@RestController
@RequestMapping("/posgrados/reporte/excel")
public class ExcelController {
        @Autowired
        private MacroExcelService reporteExcelService;
        @Autowired
        private ReporteExcelBasicoService reporteExcelBasicoService;

        @GetMapping("/ingreso-gastos")
        public ResponseEntity<byte[]> generarReporteIngresoGastos(
                        @RequestParam("mes") String mes,
                        @RequestParam("anio") Integer anio,
                        @RequestParam("codigo") String codigo) throws SQLException, IOException, ParseException {

                SimpleDateFormat formatoMes = new SimpleDateFormat("MMMM");

                Date fechaMes = formatoMes.parse(mes);

                Calendar calendarioInicio = Calendar.getInstance();
                calendarioInicio.setTime(fechaMes);
                calendarioInicio.set(Calendar.YEAR, anio);
                calendarioInicio.set(Calendar.DAY_OF_MONTH, 1);

                Date fechaInicio = calendarioInicio.getTime();

                Calendar calendarioFin = Calendar.getInstance();
                calendarioFin.setTime(fechaMes);
                calendarioFin.set(Calendar.YEAR, anio);
                calendarioFin.set(Calendar.DAY_OF_MONTH, 1);
                calendarioFin.add(Calendar.MONTH, 1);

                Date fechaFin = calendarioFin.getTime();

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment; filename=IngresosYGastosDePosgrado.xlsx");

                return ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                                .headers(headers)
                                .body(reporteExcelBasicoService.generarIngresosGastosExcel(
                                                fechaInicio,
                                                fechaFin,
                                                codigo));
        }

        @GetMapping("/macro")
        public ResponseEntity<byte[]> generarReporteExcel(
                        @RequestParam("mes") String mes,
                        @RequestParam("anio") Integer anio,
                        @RequestParam("codigo") String codigo) throws SQLException, ParseException {

                // Crear un formato para el nombre del mes
                SimpleDateFormat formatoMes = new SimpleDateFormat("MMMM");

                // Convertir el nombre del mes a un objeto Date
                Date fechaMes = formatoMes.parse(mes);

                // Crear un calendario con la fecha de inicio del mes
                Calendar calendarioInicio = Calendar.getInstance();
                calendarioInicio.setTime(fechaMes);
                calendarioInicio.set(Calendar.YEAR, anio);
                calendarioInicio.set(Calendar.DAY_OF_MONTH, 1);

                // Obtener la fecha de inicio del mes
                Date fechaInicio = calendarioInicio.getTime();

                // Crear un calendario con la fecha de final de mes
                Calendar calendarioFin = Calendar.getInstance();
                calendarioFin.setTime(fechaMes);
                calendarioFin.set(Calendar.YEAR, anio);
                calendarioFin.set(Calendar.DAY_OF_MONTH, 1);
                calendarioFin.add(Calendar.MONTH, 1);

                // Obtener la fecha de final de mes (primer día del siguiente mes)
                Date fechaFin = calendarioFin.getTime();
                // Convertir JSON a objetos Java

                return ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                                .header("Content-Disposition", "attachment; filename=ReporteMacro.xlsx")
                                .body(this.reporteExcelService.generarReporteExcel(fechaInicio, fechaFin, codigo));
        }

}