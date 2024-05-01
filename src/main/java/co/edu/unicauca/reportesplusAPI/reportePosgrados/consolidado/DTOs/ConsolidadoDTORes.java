package co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsolidadoDTORes {
    private String codigoPosgrado;
    private String nombrePosgrado;
    private BigDecimal total_ingresos;
    private BigDecimal total_descuentos;
    private BigDecimal total_neto;
    private BigDecimal contribucion;
    private BigDecimal total_disponible;
    private BigDecimal gastos_certificados;
    private BigDecimal saldo;

    public BigDecimal getTotal_ingresos() {
        return total_ingresos;
    }

    public void setTotal_ingresos(BigDecimal total_ingresos) {
        this.total_ingresos = total_ingresos;
    }

    public BigDecimal getTotal_descuentos() {
        return total_descuentos;
    }

    public void setTotal_descuentos(BigDecimal total_descuentos) {
        this.total_descuentos = total_descuentos;
    }

    public BigDecimal getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(BigDecimal total_neto) {
        this.total_neto = total_neto;
    }

    public BigDecimal getContribucion() {
        return contribucion;
    }

    public void setContribucion(BigDecimal contribucion) {
        this.contribucion = contribucion;
    }

    public BigDecimal getTotal_disponible() {
        return total_disponible;
    }

    public void setTotal_disponible(BigDecimal total_disponible) {
        this.total_disponible = total_disponible;
    }

    public BigDecimal getGastos_certificados() {
        return gastos_certificados;
    }

    public void setGastos_certificados(BigDecimal gastos_certificados) {
        this.gastos_certificados = gastos_certificados;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getCodigoPosgrado() {
        return codigoPosgrado;
    }

    public void setCodigoPosgrado(String codigoPosgrado) {
        this.codigoPosgrado = codigoPosgrado;
    }

    public String getNombrePosgrado() {
        return nombrePosgrado;
    }

    public void setNombrePosgrado(String nombrePosgrado) {
        this.nombrePosgrado = nombrePosgrado;
    }
}
