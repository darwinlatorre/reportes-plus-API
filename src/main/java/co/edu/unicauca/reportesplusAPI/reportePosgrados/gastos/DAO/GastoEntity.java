package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getNumero_movimiento() {
        return numero_movimiento;
    }

    public void setNumero_movimiento(Integer numero_movimiento) {
        this.numero_movimiento = numero_movimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCuenta_movimiento() {
        return cuenta_movimiento;
    }

    public void setCuenta_movimiento(String cuenta_movimiento) {
        this.cuenta_movimiento = cuenta_movimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getValor_definitivo() {
        return valor_definitivo;
    }

    public void setValor_definitivo(BigDecimal valor_definitivo) {
        this.valor_definitivo = valor_definitivo;
    }

    public BigDecimal getValor_registro() {
        return valor_registro;
    }

    public void setValor_registro(BigDecimal valor_registro) {
        this.valor_registro = valor_registro;
    }

    public BigDecimal getValor_ejecutado() {
        return valor_ejecutado;
    }

    public void setValor_ejecutado(BigDecimal valor_ejecutado) {
        this.valor_ejecutado = valor_ejecutado;
    }

    public BigDecimal getValor_pagado() {
        return valor_pagado;
    }

    public void setValor_pagado(BigDecimal valor_pagado) {
        this.valor_pagado = valor_pagado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
