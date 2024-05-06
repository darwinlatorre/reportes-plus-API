package co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.DTOs.ReporteMacroDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.service.ReporteMacroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Date;

@RestController
@RequestMapping("/posgrados/reporteMacro")
@Tag(name = "Controlador del reporte macro de posgrados", description = "Endpoint para permitir generar el reporte macro con los consolidados de todos los posgrados registrados")
public class ReporteMacroController {

    @Autowired
    private ReporteMacroService reporteMacroService;

    @GetMapping
    public ResponseEntity<ReporteMacroDTORes> generarReporte(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws SQLException {
        ReporteMacroDTORes reporte = reporteMacroService.generarReporteMacro(fechaInicio,fechaFin);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }
}
