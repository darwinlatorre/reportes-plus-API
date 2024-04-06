package co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados;

import java.sql.SQLException;
import java.util.List;

public interface IntReporteGastosPosDAO {
    List<ReporteGastosPosEntity> findAllReportes() throws SQLException;
}
