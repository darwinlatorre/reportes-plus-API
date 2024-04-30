package co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.common.DAOCodigosPosgrados.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.common.DAOCodigosPosgrados.CodigosEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service.GastosService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.service.IngresosService;

@Service
public class ConsolidadoServiceImpl implements ConsolidadoService {

    @Autowired
    private GastosService vReporteGastosService;
    @Autowired
    private IngresosService vReporteIngresosService;
    @Autowired
    private CodigosDAO DAOCodigosPosgrados;

    @Override
    public ConsolidadoDTORes generarConsolidado(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {

        for (CodigosEntity entity : DAOCodigosPosgrados.findAllCodes()) {
            if (entity.getCodigo().equals(codigo)) {
                ConsolidadoDTORes consolidado = new ConsolidadoDTORes();
                GastosDTORes gastos = vReporteGastosService.generarReporte(fechaInicio, fechaFin,
                        codigo);
                IngresosDTORes ingresos = vReporteIngresosService.generarReporte(fechaInicio, fechaFin,
                        codigo);
                consolidado.setTotal_ingresos(ingresos.getTotal_ingresos());
                consolidado.setTotal_descuentos(ingresos.getTotal_descuentos());
                consolidado.setTotal_neto(ingresos.getTotal_ingresos() - ingresos.getTotal_descuentos());
                consolidado.setContribucion(consolidado.getTotal_neto() * 0.20f);
                consolidado.setTotal_disponible(consolidado.getTotal_neto() - consolidado.getContribucion());
                consolidado.setGastos_certificados(gastos.getTotal());
                consolidado.setSaldo(consolidado.getTotal_disponible() - consolidado.getGastos_certificados());
                consolidado.setNombrePosgrado(entity.getDescripcion());
                consolidado.setCodigoPosgrado(codigo);
                return consolidado;
            }
        }
        return null;
    }
}
