package co.edu.unicauca.reportesplusAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "GastoModel")
public class GastoModel{
    @Id
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
