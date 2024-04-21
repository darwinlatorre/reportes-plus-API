package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.IngresoDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteIngresosPosServiceImpl implements ReporteIngresosPosService{

    @Autowired
    private ReporteIngresosPosDAO DAO;
    @Autowired
    private ReporteIngresosPosMapper ingresoMapper;

    @Override
    public List<IngresoDTORes> mapearIngresos() throws SQLException {
        List<ReporteIngresosPosEntity> ingresosSinMapear=DAO.findAllIncomeReport();

        return ingresosSinMapear
                .stream().map(ingresosEntity -> ingresoMapper.ingresoEntityToIngresoDTO(ingresosEntity))
                .collect(Collectors.toList());
    }
}
