package co.edu.unicauca.reportesplusAPI.dtos.reporteConsolidado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsolidadoDTORes {
    private String codigoPosgrado;
    private String nombrePosgrado;
    private float total_ingresos;
    private float total_descuentos;
    private float total_neto;
    private float contribucion;
    private float total_disponible;
    private float gastos_certificados;
    private float saldo;

    public float getTotal_ingresos() {
        return total_ingresos;
    }

    public void setTotal_ingresos(float total_ingresos) {
        this.total_ingresos = total_ingresos;
    }

    public float getTotal_descuentos() {
        return total_descuentos;
    }

    public void setTotal_descuentos(float total_descuentos) {
        this.total_descuentos = total_descuentos;
    }

    public float getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(float total_neto) {
        this.total_neto = total_neto;
    }

    public float getContribucion() {
        return contribucion;
    }

    public void setContribucion(float contribucion) {
        this.contribucion = contribucion;
    }

    public float getTotal_disponible() {
        return total_disponible;
    }

    public void setTotal_disponible(float total_disponible) {
        this.total_disponible = total_disponible;
    }

    public float getGastos_certificados() {
        return gastos_certificados;
    }

    public void setGastos_certificados(float gastos_certificados) {
        this.gastos_certificados = gastos_certificados;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
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
