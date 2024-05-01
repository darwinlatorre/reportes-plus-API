package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.mapper.GastosMapper;

@Service
public class GastosServiceImpl implements GastosService {

        @Autowired
        private GastosDAO gastosDAO;
        @Autowired
        private GastosMapper gastosMapper;
        @Autowired
        private CodigosDAO DAOCodigosPosgrados;

        public GastosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
                        throws SQLException {

                GastosDTORes gastosDTORes = new GastosDTORes();

                java.sql.Date fechaIncioSQL = new java.sql.Date(fechaInicio.getTime());
                java.sql.Date fechaFinSQL = new java.sql.Date(fechaFin.getTime());

                List<GastoEntity> GastoEntityList = gastosDAO.encontrarReportesPorFechaYCódigo(fechaIncioSQL,
                                fechaFinSQL, codigo);
                gastosDTORes.setGastos(gastosMapper.gastoEntityListToGastoDTOResList(GastoEntityList));

                BigDecimal gastoTotal = gastosDTORes.getGastos().stream()
                                .map(gasto -> BigDecimal.valueOf(gasto.getValor_definitivo()))
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                gastosDTORes.setCodigoPosgrado(DAOCodigosPosgrados.encontrarPorCodigo(codigo).getDescripcion());
                gastosDTORes.setFechaInicio(fechaInicio);
                gastosDTORes.setFechaFin(fechaFin);
                gastosDTORes.setTotal(gastoTotal);

                return gastosDTORes;
        }
}
