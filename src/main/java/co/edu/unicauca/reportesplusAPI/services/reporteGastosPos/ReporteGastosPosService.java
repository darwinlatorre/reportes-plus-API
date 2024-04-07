package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface ReporteGastosPosService {
    public List<GastoDTORes> mapearGastos() throws SQLException;
}
