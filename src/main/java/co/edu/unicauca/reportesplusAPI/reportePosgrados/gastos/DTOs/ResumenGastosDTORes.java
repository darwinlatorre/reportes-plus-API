package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumenGastosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal total;
    private String codigoPosgrado;
    private String nombrePosgrado;
    private List<GastoDTORes> gastos;
}
