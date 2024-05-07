package co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.DTOs.ConsolidadoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.consolidado.service.ConsolidadoService;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.reporteMacro.DTOs.ReporteMacroDTORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReporteMacroServiceImpl implements ReporteMacroService {
    @Autowired
    private CodigosDAO codigosDAO;
    @Autowired
    private ConsolidadoService consolidadoService;

    @Override
    public ReporteMacroDTORes generarReporteMacro(Date fechaInicio, Date fechaFin) throws SQLException {
        List<CodigoEntity> codigos = codigosDAO.encontrarTodosLosCodigos();
        ReporteMacroDTORes reporte = new ReporteMacroDTORes();

        reporte.setConsolidados(new ArrayList<>());
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);

        //filtrar solo los codigos de posgrados
        for(CodigoEntity codigo:codigos)
        {
            if(codigo.getCodigo().startsWith("14")) {
                ConsolidadoDTORes consolidado = consolidadoService.generarConsolidado(fechaInicio, fechaFin,
                        codigo.getCodigo());
                reporte.getConsolidados().add(consolidado);
                System.out.println(consolidado.getNombrePosgrado()+" "+consolidado.getSaldo());
            }
        }
        return reporte;
    }
}
