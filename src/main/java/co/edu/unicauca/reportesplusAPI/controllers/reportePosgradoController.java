package co.edu.unicauca.reportesplusAPI.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posgrados/report")
@Tag(name = "Controlador de reportes gastos de posgrados", description = "Endpoint para permitir generar tipos de reporte de gastos de un posgrados en especifico o de varios")
public class reportePosgradoController {

    // TODO: Cada que se implementa un metodo, documentar con swagger
    // Ejemplo
    /*
     * @Operation(summary = "Registra una reserva", description =
     * "crea una reserva en el sistema.", responses = {
     * 
     * @ApiResponse(responseCode = "200", description =
     * "reservas creada exitosamente", content = @Content(array
     * = @ArraySchema(schema = @Schema(implementation = UserRegisterRes.class)),
     * mediaType = "application/json")),
     * 
     * @ApiResponse(responseCode = "404", description = "No se creo la reservas",
     * content = @Content(mediaType = "application/json"))
     * })
     * 
     * @PostMapping()
     * public ResponseEntity<String> crearBooking(@RequestBody BookingReq
     * bookingModel) {
     * bookingModel.setFechaSolicitud(LocalDateTime.now());
     * return this.bookingService.crearBooking(bookingModel);
     * }
     */
}
