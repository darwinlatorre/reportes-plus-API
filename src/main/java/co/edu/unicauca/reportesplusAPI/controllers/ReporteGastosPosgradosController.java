package co.edu.unicauca.reportesplusAPI.controllers;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteGastosPosService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/posgrados/reporte/gastos")
@Tag(name = "Controlador de reportes(gastos) de posgrados", description = "Endpoint para permitir generar tipos de reporte de gastos de un posgrados en especifico o de varios")
public class ReporteGastosPosgradosController {
    // TODO: Cada que se implementa un metodo, documentar con swagger

    @Autowired
    private ReporteGastosPosService vReporteService;

    @GetMapping
    public ReportesGastosPosDTORes encontrarReportePorFecha(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("codigo") String codigo) throws SQLException {
        return vReporteService.generarReporte(fechaInicio, fechaFin, codigo);
    }
}
