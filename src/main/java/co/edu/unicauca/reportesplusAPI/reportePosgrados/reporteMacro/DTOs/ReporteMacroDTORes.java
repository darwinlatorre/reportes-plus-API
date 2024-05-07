package co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.DTOs;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteMacroDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private List<ConsolidadoDTORes> consolidados;
}
