package co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
@Tag(name = "Controlador de reportes(consolidado) de posgrados", description = "Endpoint para permitir generar el consoliddado de los reportes de ingresos y gastos")
public class ConsolidadoController {
    @Autowired
    ConsolidadoService vConsolidadoService;

    @GetMapping("/fecha")
    public ResponseEntity<ConsolidadoDTORes> encontrarConsolidadoPorFecha(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("codigo") String codigo) throws SQLException {
        ConsolidadoDTORes consolidado = vConsolidadoService.generarConsolidado(fechaInicio, fechaFin,
                codigo);
        if (consolidado == null)
            return new ResponseEntity<>(consolidado, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(consolidado, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ConsolidadoDTORes> encontrarConsolidadoPorMes(
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

        ConsolidadoDTORes consolidado = vConsolidadoService.generarConsolidado(fechaInicio, fechaFin,
                codigo);
        /*
         * if(consolidado==null)
         * return new ResponseEntity<>(consolidado, HttpStatus.NOT_FOUND);
         */
        return new ResponseEntity<>(consolidado, HttpStatus.OK);
    }
}
