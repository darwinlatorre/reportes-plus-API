package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GastoDTORes {
    private Integer ID;
    private String tipo_documento;
    private Integer numero_movimiento;
    private Date fecha;
    private String cuenta_movimiento;
    private String observacion;
    private Double valor_definitivo;
    private Double valor_registro;
    private Double valor_ejecutado;
    private Double valor_pagado;
    private Double saldo;
    private String estado;
}
