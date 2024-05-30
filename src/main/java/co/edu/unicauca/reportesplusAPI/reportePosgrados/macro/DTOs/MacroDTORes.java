package co.edu.unicauca.reportesplusAPI.reportePosgrados.macro.DTOs;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class MacroDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private List<ConsolidadoDTORes> consolidados;

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

    public List<ConsolidadoDTORes> getConsolidados() {
        return consolidados;
    }

    public void setConsolidados(List<ConsolidadoDTORes> consolidados) {
        this.consolidados = consolidados;
    }

}
