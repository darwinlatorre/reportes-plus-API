package co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos;


import java.util.Date;
import java.util.List;

public class ReporteIngresosPosDTORes {
    private Date fechaInicio;
    private Date fechaFin;
    private float total_ingresos;
    private float total_descuentos;
    private String codigoPosgrado;
    private List<IngresoDTORes> ingresos;
    private List<IngresoDTORes> descuentos;
}
