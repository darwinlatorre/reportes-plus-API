package co.edu.unicauca.reportesplusAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOCD")
public class GastoModel extends MovimientoModel{
    private float valor_definitivo;
    private float valor_registro;
    private float valor_ejecutado;
    private float valor_pagado;
    private float saldo;
    private String estado;
}
