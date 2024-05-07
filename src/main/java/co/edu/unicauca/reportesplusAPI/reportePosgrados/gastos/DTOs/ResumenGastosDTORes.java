package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class ResumenGastosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal gastoTotal;
    private String codigo;
    private String nombrePosgrado;
    private List<GastoDTORes> listaGastos;

    public ResumenGastosDTORes(Date fechaInicio, Date fechaFin, BigDecimal gastoTotal, String codigo,
            String nombrePosgrado, List<GastoDTORes> listaGastos) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.gastoTotal = gastoTotal;
        this.codigo = codigo;
        this.nombrePosgrado = nombrePosgrado;
        this.listaGastos = listaGastos;
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

    public BigDecimal getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(BigDecimal gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePosgrado() {
        return nombrePosgrado;
    }

    public void setNombrePosgrado(String nombrePosgrado) {
        this.nombrePosgrado = nombrePosgrado;
    }

    public List<GastoDTORes> getListaGastos() {
        return listaGastos;
    }

    public void setListaGastos(List<GastoDTORes> listaGastos) {
        this.listaGastos = listaGastos;
    }

}
