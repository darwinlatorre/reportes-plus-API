package co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportesGastosPosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private float total;
    private List<GastoDTORes> gastos;

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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<GastoDTORes> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastoDTORes> gastos) {
        this.gastos = gastos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        sb.append("ReporteGastosPostDTORes:\n");

        sb.append("Gastos en Rango de fechas: " +fechaInicio + " a: " + fechaFin + ":\n");
        for (GastoDTORes gasto : gastos) {
            sb.append(gasto).append("\n\n\n");
        }

        sb.append("Total de gastos sacados de Valor_Definitivo: ").append(total).append("\n");

        return sb.toString();
    }

}
