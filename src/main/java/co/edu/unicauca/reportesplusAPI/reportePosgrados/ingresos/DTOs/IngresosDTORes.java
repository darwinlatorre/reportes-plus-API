package co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class IngresosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private String codigoPosgrado;
    private String nombrePosgrado;
    private BigDecimal total_ingresos;
    private BigDecimal total_descuentos;
    private List<IngresoDTORes> ingresos;

    private List<IngresoDTORes> descuentos;

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

    public String getCodigoPosgrado() {
        return codigoPosgrado;
    }

    public void setCodigoPosgrado(String codigoPosgrado) {
        this.codigoPosgrado = codigoPosgrado;
    }

    public List<IngresoDTORes> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoDTORes> ingresos) {
        this.ingresos = ingresos;
    }

    public List<IngresoDTORes> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<IngresoDTORes> descuentos) {
        this.descuentos = descuentos;
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
        sb.append("DTO DE REPORTE DE INGRESOS{\n");
        sb.append("  fechaInicio: ").append(fechaInicio).append("\n");
        sb.append("  fechaFin: ").append(fechaFin).append("\n");
        sb.append("  codigoPosgrado: ").append(codigoPosgrado).append("\n");
        sb.append("  total_ingresos: ").append(total_ingresos).append("\n");
        sb.append("  total_descuentos: ").append(total_descuentos).append("\n\n");
        sb.append(" ++++++++ INGRESOS ++++++++: \n\n\n");
        for (IngresoDTORes ingreso : ingresos) {
            sb.append("    ").append(ingreso).append("\n");
        }
        sb.append("\n\n +++++++++ DESCUENTOS: ++++++++++++\n\n");
        for (IngresoDTORes descuento : descuentos) {
            sb.append("    ").append(descuento).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
