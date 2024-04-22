package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.dtos.reporteConsolidado.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.ReporteIngresosPosDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;

@Service
public class ReporteConsolidadoPosServiceImpl implements ReporteConsolidadoPosService{

    @Autowired
    private ReporteGastosPosService vReporteGastosService;
    @Autowired
    private ReporteIngresosPosService vReporteIngresosService;


    @Override
    public ConsolidadoDTORes generarConsolidado(Date fechaInicio, Date fechaFin, String codigo) throws SQLException {
        ConsolidadoDTORes consolidado=new ConsolidadoDTORes();
        ReportesGastosPosDTORes gastos=vReporteGastosService.generarReporte(fechaInicio,fechaFin,codigo);
        ReporteIngresosPosDTORes ingresos=vReporteIngresosService.generarReporte(fechaInicio,fechaFin,codigo);
        consolidado.setTotal_ingresos(ingresos.getTotal_ingresos());
        consolidado.setTotal_descuentos(ingresos.getTotal_descuentos());
        consolidado.setTotal_neto(ingresos.getTotal_ingresos()- ingresos.getTotal_descuentos());
        consolidado.setContribucion(consolidado.getTotal_neto()*0.20f);
        consolidado.setTotal_disponible(consolidado.getTotal_neto()-consolidado.getContribucion());
        consolidado.setGastos_certificados(gastos.getTotal());
        consolidado.setSaldo(consolidado.getTotal_disponible()-consolidado.getGastos_certificados());
        return consolidado;
    }
}
