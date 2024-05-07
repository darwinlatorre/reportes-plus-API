package co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.ResumenGastosDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.DTOs.ReporteMacroDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.service.ReporteMacroService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/posgrados/reportemacro")
@Tag(name = "Controlador del reporte macro de posgrados", description = "Endpoint para permitir generar el reporte macro con los consolidados de todos los posgrados registrados")
public class ReporteMacroController {

    @Autowired
    private ReporteMacroService reporteMacroService;

    @GetMapping("/fecha")
    public ResponseEntity<ReporteMacroDTORes> generarReporte(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin)
            throws SQLException {
        ReporteMacroDTORes reporte = reporteMacroService.generarReporteMacro(fechaInicio, fechaFin);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ReporteMacroDTORes> obtenenerReportePorMes(
            @RequestParam("mes") String mes,
            @RequestParam("anio") Integer anio) throws SQLException, ParseException {

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

        ReporteMacroDTORes reporte = reporteMacroService.generarReporteMacro(fechaInicio, fechaFin);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }
}
