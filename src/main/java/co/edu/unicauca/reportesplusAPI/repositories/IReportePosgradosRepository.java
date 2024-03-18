package co.edu.unicauca.reportesplusAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.reportesplusAPI.models.reportePosgradosModel;

//TODO: Verificar si el identificador del modelor es de tipo Interger o otro.
public interface IReportePosgradosRepository extends JpaRepository<reportePosgradosModel, Integer> {

}
