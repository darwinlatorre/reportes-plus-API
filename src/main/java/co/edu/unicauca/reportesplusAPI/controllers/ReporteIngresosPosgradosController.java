package co.edu.unicauca.reportesplusAPI.controllers;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.ReporteIngresosPosDTORes;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteGastosPosService;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteIngresosPosService;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteIngresosPosServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posgrados/reporte/ingresos")
@Tag(name = "Controlador de reportes(ingresos) de posgrados", description = "Endpoint para permitir generar tipos de reporte de ingresos de un posgrados en especifico o de varios")
public class ReporteIngresosPosgradosController {

    @Autowired
    private ReporteIngresosPosService vReporteService;

    @GetMapping("/fecha")
    public ReporteIngresosPosDTORes encontrarReportePorFecha(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("codigo") String codigo) throws SQLException, JsonProcessingException {
        return  vReporteService.generarReporte(fechaInicio, fechaFin, codigo);
    }

    @GetMapping
    public ReporteIngresosPosDTORes encontrarReportePorMes(
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

        // Mostrar las fechas generadas
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Fecha de inicio del mes: " + formatoFecha.format(fechaInicio));
        System.out.println("Fecha de final de mes: " + formatoFecha.format(fechaFin));

        return  vReporteService.generarReporte(fechaInicio, fechaFin, codigo);
    }
}
