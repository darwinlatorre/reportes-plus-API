package co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteGastosPosEntity {

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
