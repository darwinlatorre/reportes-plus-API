package co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service.ConsolidadoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/posgrados/reporte/consolidado")
@Tag(name = "Controlador de reportes(consolidado) de posgrados", description = "Operaciones relacionadas con el consolidado")
public class ConsolidadoController {
    @Autowired
    ConsolidadoService vConsolidadoService;

    @GetMapping("/fecha")
    @Operation(summary = "Obtener consolidado por fecha", description = "Obtiene el consolidado para un rango de fechas y un código dado.")
    @ApiResponse(responseCode = "200", description = "Consolidado encontrado", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ConsolidadoDTORes.class))})
    @ApiResponse(responseCode = "404", description = "Consolidado no encontrado")

    public ResponseEntity<ConsolidadoDTORes> encontrarConsolidadoPorFecha(
            @Parameter(description = "Fecha de inicio en formato ISO (YYYY-MM-DD)", required = true)
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @Parameter(description = "Fecha de fin en formato ISO (YYYY-MM-DD)", required = true)
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @Parameter(description = "Código del consolidado", required = true)
            @RequestParam("codigo") String codigo) throws SQLException {
        ConsolidadoDTORes vConsolidado = vConsolidadoService.generarConsolidado(fechaInicio, fechaFin,
                codigo);
        if (vConsolidado != null) {
            return ResponseEntity.ok(vConsolidado);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    @Operation(summary = "Obtener consolidado por mes", description = "Obtiene el consolidado para un mes, un año específico y un código dado.")
    @ApiResponse(responseCode = "200", description = "Consolidado encontrado",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ConsolidadoDTORes.class))})
    @ApiResponse(responseCode = "404", description = "Consolidado no encontrado")

    public ResponseEntity<ConsolidadoDTORes> encontrarConsolidadoPorMes(
            @Parameter(description = "Nombre del mes (ej. 'enero', 'febrero', etc.)", required = true)
            @RequestParam("mes") String mes,
            @Parameter(description = "Año", required = true)
            @RequestParam("anio") Integer anio,
            @Parameter(description = "Código del consolidado", required = true)
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

        ConsolidadoDTORes vConsolidado = vConsolidadoService.generarConsolidado(fechaInicio, fechaFin,codigo);
        if (vConsolidado != null) {
            return ResponseEntity.ok(vConsolidado);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
