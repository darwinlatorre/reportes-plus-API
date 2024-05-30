package co.edu.unicauca.reportesplusAPI.reportePosgrados.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.macroExcelService.MacroExcelServiceImpl;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.excel.service.reporteExcelBasicoService.ReporteExcelBasicoService;

@RestController
@RequestMapping("/posgrados/reporte/excel")
@Tag(name = "Controlador del reporte en excel", description = "Operaciones relacionadas con la generación de reportes en Excel")
public class ExcelController {
        @Autowired
        private MacroExcelServiceImpl reporteExcelService;
        @Autowired
        private ReporteExcelBasicoService reporteExcelBasicoService;

        @GetMapping("/ingreso-gastos")
        @Operation(summary = "Generar reporte de ingresos y gastos",
                description = "Genera un reporte en formato Excel de los ingresos y gastos para un mes,año específico y un código dado.")
        @ApiResponse(responseCode = "200", description = "Archivo Excel generado correctamente",
                content = {@Content(mediaType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        schema = @Schema(type = "string", format = "binary"))})
        public ResponseEntity<byte[]> generarReporteIngresoGastos(
                @Parameter(description = "Nombre del mes (ej. 'enero', 'febrero', etc.)", required = true)
                @RequestParam("mes") String mes,
                @Parameter(description = "Año", required = true)
                @RequestParam("anio") Integer anio,
                @Parameter(description = "Código", required = true)
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
        @Operation(summary = "Generar reporte macro en Excel",
                description = "Genera un reporte macro en formato Excel para un mes, año específico y un código dado.")
        @ApiResponse(responseCode = "200", description = "Archivo Excel generado correctamente",
                content = {@Content(mediaType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        schema = @Schema(type = "string", format = "binary"))})
        public ResponseEntity<byte[]> generarReporteExcel(
                @Parameter(description = "Nombre del mes (ej. 'enero', 'febrero', etc.)", required = true)
                @RequestParam("mes") String mes,
                @Parameter(description = "Año", required = true)
                @RequestParam("anio") Integer anio,
                @Parameter(description = "Código", required = true)
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
