package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteGastosPosServiceImpl implements ReporteGastosPosService{

    @Autowired
    private ReporteGastosPosDAO DAO;
    @Autowired
    private ReporteGastosPosMapper gastoMapper;
    @Override
    public List<GastoDTORes> mapearGastos() throws SQLException {//Usar este metodo para obtener la lista de gastos mapeados a DTO
        List<ReporteGastosPosEntity> gastosSinMapear=DAO.findAllReportes();

        return gastosSinMapear
                .stream().map(gastoEntity -> gastoMapper.gastoEntityToGastoDTO(gastoEntity))
                .collect(Collectors.toList());
    }
}
