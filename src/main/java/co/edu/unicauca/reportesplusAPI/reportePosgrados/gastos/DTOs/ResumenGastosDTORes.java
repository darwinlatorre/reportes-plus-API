package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class ResumenGastosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal gastoTotal;
    private String codigo;
    private String nombrePosgrado;
    private List<GastoDTORes> listaGastos;

    public ResumenGastosDTORes() {
    }

    public ResumenGastosDTORes(Date fechaInicio, Date fechaFin, BigDecimal gastoTotal, String codigo,
            String nombrePosgrado, List<GastoDTORes> listaGastos) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.gastoTotal = gastoTotal;
        this.codigo = codigo;
        this.nombrePosgrado = nombrePosgrado;
        this.listaGastos = listaGastos;
    }

    public BigDecimal getSumaValorDefinitivo() {
        return listaGastos.stream()
                .map(gasto -> gasto.getValor_definitivo())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSumaValorRegistros() {
        return listaGastos.stream()
                .map(gasto -> gasto.getValor_registro())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSumaValorEjecutado() {
        return listaGastos.stream()
                .map(gasto -> gasto.getValor_ejecutado())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSumaValorPagado() {
        return listaGastos.stream()
                .map(gasto -> gasto.getValor_pagado())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSumaValorSaldo() {
        return listaGastos.stream()
                .map(gasto -> gasto.getSaldo())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
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
