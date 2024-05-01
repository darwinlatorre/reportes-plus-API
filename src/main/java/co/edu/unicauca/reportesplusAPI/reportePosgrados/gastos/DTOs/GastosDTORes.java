package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GastosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal total;
    private String codigoPosgrado;
    private String nombrePosgrado;
    private List<GastoDTORes> gastos;

    public String getCodigoPosgrado() {
        return codigoPosgrado;
    }

    public void setCodigoPosgrado(String codigoPosgrado) {
        this.codigoPosgrado = codigoPosgrado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<GastoDTORes> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastoDTORes> gastos) {
        this.gastos = gastos;
    }

    public String getNombrePosgrado() {
        return nombrePosgrado;
    }

    public void setNombrePosgrado(String nombrePosgrado) {
        this.nombrePosgrado = nombrePosgrado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ReporteGastosPostDTORes:\n");

        sb.append("Gastos en Rango de fechas: " + fechaInicio + " a: " + fechaFin + ":\n");
        for (GastoDTORes gasto : gastos) {
            sb.append(gasto).append("\n\n\n");
        }

        sb.append("Total de gastos sacados de Valor_Definitivo: ").append(total).append("\n");

        return sb.toString();
    }

}
