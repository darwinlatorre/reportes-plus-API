package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
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
        List<ReporteGastosPosEntity> gastosSinMapear=DAO.findAllExpenseReport();

        return gastosSinMapear
                .stream().map(gastoEntity -> gastoMapper.gastoEntityToGastoDTO(gastoEntity))
                .collect(Collectors.toList());
    }
    @Override
    public List<GastoDTORes> mapearGastosPorFechas(Date fechaInicio, Date fechaFin, String codigo) throws SQLException {

        List<ReporteGastosPosEntity> gastosSinMapear = DAO.findAllExpenseReport();
        return gastosSinMapear.stream()
                .filter(gastoEntity -> {
                    Date fechaGasto = gastoEntity.getFecha();
                    String cuentaMovimiento = gastoEntity.getCuenta_movimiento();
                    String codigoTipo = cuentaMovimiento.substring(cuentaMovimiento.lastIndexOf(".") + 1);
                    return !fechaGasto.before(fechaInicio) && !fechaGasto.after(fechaFin) && codigoTipo.equals(codigo);
                })
                .map(gastoEntity -> gastoMapper.gastoEntityToGastoDTO(gastoEntity))
                .collect(Collectors.toList());


    }

    public ReportesGastosPosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo) throws SQLException{

        ReportesGastosPosDTORes reporte = new ReportesGastosPosDTORes();
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.setCodigoPosgrado(codigo);
        reporte.setGastos(mapearGastosPorFechas(fechaInicio,fechaFin,codigo));

        List<GastoDTORes> listaGastos = mapearGastosPorFechas(fechaInicio, fechaFin, codigo);
        float sumaValoresDefinitivos = (float) listaGastos.stream()
                .mapToDouble(gasto -> gasto.getValor_definitivo())
                .sum();

        reporte.setTotal(sumaValoresDefinitivos);
        return reporte;
    }
}
