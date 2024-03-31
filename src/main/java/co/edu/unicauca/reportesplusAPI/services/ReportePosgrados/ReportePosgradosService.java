package co.edu.unicauca.reportesplusAPI.services.ReportePosgrados;

//A la hora de utilizar estas clases de servicios, utilizar la interfaz y no la implementacion

import co.edu.unicauca.reportesplusAPI.models.ReporteGastosModel;

import java.util.List;

public interface ReportePosgradosService {

     public List<ReporteGastosModel> findAll();
     public ReporteGastosModel findByModel(Integer id);

}
