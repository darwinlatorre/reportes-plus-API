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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posgrados/reporte/ingresos")
@Tag(name = "Controlador de reportes(ingresos) de posgrados", description = "Endpoint para permitir generar tipos de reporte de ingresos de un posgrados en especifico o de varios")
public class ReporteIngresosPosgradosController {

    @Autowired
    private ReporteIngresosPosService vReporteService;

    @GetMapping
    public ReporteIngresosPosDTORes encontrarReportePorFecha(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("codigo") String codigo) throws SQLException, JsonProcessingException {
        return  vReporteService.generarReporte(fechaInicio, fechaFin, codigo);
    }

}
