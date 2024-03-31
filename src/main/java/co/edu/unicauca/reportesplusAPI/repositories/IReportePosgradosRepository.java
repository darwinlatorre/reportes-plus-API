package co.edu.unicauca.reportesplusAPI.repositories;

import co.edu.unicauca.reportesplusAPI.models.GastoModel;
import co.edu.unicauca.reportesplusAPI.models.MOCDtable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.reportesplusAPI.models.ReporteGastosModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO: Verificar si el identificador del modelor es de tipo Interger o otro.
@Repository
public interface IReportePosgradosRepository extends JpaRepository<ReporteGastosModel, Integer> {
@Query("SELECT new GastoModel(m.ID, m.MOCDCDTD, m.MOCDCDND, m.MOCDFECH, m.MOCDCUMO, m.MOCDOBSE, m.MOCDVADE,m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDESTA) FROM MOCDtable m")
List<GastoModel> obtenerMovimientos();


}
