package co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Double getValor_definitivo() {
        return valor_definitivo;
    }

    public void setValor_definitivo(Double valor_definitivo) {
        this.valor_definitivo = valor_definitivo;
    }

    public Double getValor_registro() {
        return valor_registro;
    }

    public void setValor_registro(Double valor_registro) {
        this.valor_registro = valor_registro;
    }

    public Double getValor_ejecutado() {
        return valor_ejecutado;
    }

    public void setValor_ejecutado(Double valor_ejecutado) {
        this.valor_ejecutado = valor_ejecutado;
    }

    public Double getValor_pagado() {
        return valor_pagado;
    }

    public void setValor_pagado(Double valor_pagado) {
        this.valor_pagado = valor_pagado;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "GastoDTORes{" +
                "ID=" + ID +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", numero_movimiento=" + numero_movimiento +
                ", fecha=" + fecha +
                ", cuenta_movimiento='" + cuenta_movimiento + '\'' +
                ", observacion='" + observacion + '\'' +
                ", valor_definitivo=" + valor_definitivo +
                ", valor_registro=" + valor_registro +
                ", valor_ejecutado=" + valor_ejecutado +
                ", valor_pagado=" + valor_pagado +
                ", saldo=" + saldo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
