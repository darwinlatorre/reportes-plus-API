package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastosEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.mapper.GastosMapper;

@Service
public class GastosServiceImpl implements GastosService {

    @Autowired
    private GastosDAO DAO;
    @Autowired
    private GastosMapper gastoMapper;
    @Autowired
    private CodigosDAO DAOCodigosPosgrados;

    @Override
    public List<GastoDTORes> mapearGastos() throws SQLException {// Usar este metodo para obtener la lista de gastos
                                                                 // mapeados a DTO
        List<GastosEntity> gastosSinMapear = DAO.findAllExpenseReport();

        return gastosSinMapear
                .stream().map(gastoEntity -> gastoMapper.gastoEntityToGastoDTO(gastoEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<GastoDTORes> mapearGastosPorFechas(Date fechaInicio, Date fechaFin, String codigo) throws SQLException {

        List<GastosEntity> gastosSinMapear = DAO.findAllExpenseReport();
        return gastosSinMapear.stream()
                .filter(gastoEntity -> {
                    Date fechaGasto = gastoEntity.getFecha();
                    String cuentaMovimiento = gastoEntity.getCuenta_movimiento();
                    String codigoTipo = cuentaMovimiento.substring(cuentaMovimiento.lastIndexOf(".") + 1);
                    return fechaGasto.before(fechaFin) && fechaGasto.after(fechaInicio) && codigoTipo.equals(codigo);
                })
                .map(gastoEntity -> gastoMapper.gastoEntityToGastoDTO(gastoEntity))
                .collect(Collectors.toList());

    }

    public GastosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {

        GastosDTORes reporte = new GastosDTORes();
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.setCodigoPosgrado(codigo);
        reporte.setGastos(mapearGastosPorFechas(fechaInicio, fechaFin, codigo));
        for (CodigosEntity entity : DAOCodigosPosgrados.findAllCodes()) {
            if (entity.getCodigo().equals(codigo)) {
                reporte.setNombrePosgrado(entity.getDescripcion());
            }
        }

        List<GastoDTORes> listaGastos = mapearGastosPorFechas(fechaInicio, fechaFin, codigo);
        float sumaValoresDefinitivos = (float) listaGastos.stream()
                .mapToDouble(gasto -> gasto.getValor_definitivo())
                .sum();

        reporte.setTotal(sumaValoresDefinitivos);
        return reporte;
    }
}
