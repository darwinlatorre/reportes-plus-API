package co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.ResumenGastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service.GastosService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs.IngresosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.service.IngresosService;

@Service
public class ConsolidadoServiceImpl implements ConsolidadoService {

    @Autowired
    private GastosService gastosService;
    @Autowired
    private IngresosService ingresosService;
    @Autowired
    private CodigosDAO codigosDAO;

    @Override
    public ConsolidadoDTORes generarConsolidado(Date fechaInicio, Date fechaFin, String codigo)
            throws SQLException {

        String codigoEncontrado = codigosDAO.encontrarPorCodigo(codigo).getDescripcion();
        if (codigoEncontrado != null) {
            ConsolidadoDTORes consolidado = new ConsolidadoDTORes();
            ResumenGastosDTORes gastos = gastosService.generarReporte(fechaInicio, fechaFin,
                    codigo);
            IngresosDTORes ingresos = ingresosService.generarReporte(fechaInicio, fechaFin,
                    codigo);
            consolidado.setTotal_ingresos(ingresos.getTotal_ingresos());
            consolidado.setTotal_descuentos(ingresos.getTotal_descuentos());
            consolidado.setTotal_neto(
                    ingresos.getTotal_ingresos().subtract(ingresos.getTotal_descuentos()));
            consolidado.setContribucion(consolidado.getTotal_neto().multiply(BigDecimal.valueOf(0.20f)));
            consolidado
                    .setTotal_disponible(consolidado.getTotal_neto()
                            .subtract(consolidado.getContribucion()));
            consolidado.setGastos_certificados(gastos.getTotal());
            consolidado
                    .setSaldo(consolidado.getTotal_disponible()
                            .subtract(consolidado.getGastos_certificados()));
            consolidado.setNombrePosgrado(codigoEncontrado);
            consolidado.setCodigoPosgrado(codigo);
            return consolidado;
        }
        return null;
    }
}
