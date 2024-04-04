package co.edu.unicauca.reportesplusAPI.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/posgrados/report")
@Tag(name = "Controlador de reportes gastos de posgrados", description = "Endpoint para permitir generar tipos de reporte de gastos de un posgrados en especifico o de varios")
public class ReporteGastosPosgradosController {
    // TODO: Cada que se implementa un metodo, documentar con swagger
}
