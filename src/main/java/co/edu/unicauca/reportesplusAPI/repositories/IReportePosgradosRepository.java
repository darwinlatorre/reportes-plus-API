package co.edu.unicauca.reportesplusAPI.repositories;

import co.edu.unicauca.reportesplusAPI.models.MovimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.reportesplusAPI.models.ReporteGastosModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO: Verificar si el identificador del modelor es de tipo Interger o otro.
@Repository
public interface IReportePosgradosRepository extends JpaRepository<ReporteGastosModel, String> {
    @Query("SELECT new GastoModel(MOCD.ID, MOCD.MOCDCDTD, MOCD.MOCDCDND, MOCD.MOCDFECH, MOCD.MOCDCUMO, MOCD.MOCDOBSE, MOCD.MOCDVADE) FROM MOCD")
    List<MovimientoModel> obtenerMovimientos();
}
