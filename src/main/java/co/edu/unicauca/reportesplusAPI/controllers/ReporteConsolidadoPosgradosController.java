package co.edu.unicauca.reportesplusAPI.controllers;


import co.edu.unicauca.reportesplusAPI.dtos.reporteConsolidado.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteConsolidadoPosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Date;

@RestController
@RequestMapping("/posgrados/reporte/consolidado")
@Tag(name = "Controlador de reportes(consolidado) de posgrados", description = "Endpoint para permitir generar el consoliddado de los reportes de ingresos y gastos")
public class ReporteConsolidadoPosgradosController {
    @Autowired
    ReporteConsolidadoPosService vConsolidadoService;

    @GetMapping
    public ConsolidadoDTORes encontrarConsolidadoPorFecha(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("codigo") String codigo) throws SQLException {
        return vConsolidadoService.generarConsolidado(fechaInicio, fechaFin, codigo);
    }
}
