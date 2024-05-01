package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GastoEntity {

    private Integer ID;
    private String tipo_documento;
    private Integer numero_movimiento;
    private Date fecha;
    private String cuenta_movimiento;
    private String observacion;
    private BigDecimal valor_definitivo;
    private BigDecimal valor_registro;
    private BigDecimal valor_ejecutado;
    private BigDecimal valor_pagado;
    private BigDecimal saldo;
    private String estado;
}
