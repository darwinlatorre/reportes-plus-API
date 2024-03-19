package co.edu.unicauca.reportesplusAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.reportesplusAPI.models.ReporteGastosModel;
import org.springframework.stereotype.Repository;

//TODO: Verificar si el identificador del modelor es de tipo Interger o otro.
@Repository
public interface IReportePosgradosRepository extends JpaRepository<ReporteGastosModel, String> {

}
