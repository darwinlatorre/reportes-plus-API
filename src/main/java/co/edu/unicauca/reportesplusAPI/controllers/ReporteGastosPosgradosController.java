package co.edu.unicauca.reportesplusAPI.controllers;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteGastosPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posgrados/report")
@Tag(name = "Controlador de reportes gastos de posgrados", description = "Endpoint para permitir generar tipos de reporte de gastos de un posgrados en especifico o de varios")
public class ReporteGastosPosgradosController {
    // TODO: Cada que se implementa un metodo, documentar con swagger

    @Autowired
    private ReporteGastosPosService vReporteService;

    @GetMapping
    public ReportesGastosPosDTORes encontrarReportePorFecha(@RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
                                                            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
                                                            @RequestParam("codigo") String codigo) throws SQLException {
        return vReporteService.generarReporte(fechaInicio, fechaFin, codigo);
    }
}
