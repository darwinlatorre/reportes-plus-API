package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.IngresoDTORes;

import java.sql.SQLException;
import java.util.List;

public interface ReporteIngresosPosService {
    public List<IngresoDTORes> mapearIngresos() throws SQLException;
}
