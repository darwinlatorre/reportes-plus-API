package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO.CodigosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastosDAO;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.ResumenGastosDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.mapper.GastosMapper;

@Service
public class GastosServiceImpl implements GastosService {

	@Autowired
	private GastosDAO gastosDAO;
	@Autowired
	private GastosMapper gastoMapper;
	@Autowired
	private CodigosDAO codigosDAO;

	public ResumenGastosDTORes generarReporte(Date fechaInicio, Date fechaFin, String codigo)
			throws SQLException {

		List<GastoEntity> GastoEntityList = gastosDAO.encontrarReportesPorFechaYCodigo(ajustarFecha(fechaInicio),
				ajustarFecha(fechaFin), codigo);

		List<GastoDTORes> listaGastos = gastoMapper.gastoEntityListToGastoDTOResList(GastoEntityList);

		BigDecimal gastoTotal = listaGastos.stream()
				.map(gasto -> BigDecimal.valueOf(gasto.getValor_definitivo()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		String codigoEncontrado = codigosDAO.encontrarPorCodigo(codigo).getDescripcion();

		ResumenGastosDTORes resumenGastosDTORes = gastoMapper.convertirAGastosDTORes(listaGastos, codigoEncontrado,
				fechaInicio, fechaFin,
				gastoTotal, null);

		return resumenGastosDTORes;
	}

	private java.sql.Date ajustarFecha(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return new java.sql.Date(calendar.getTimeInMillis());
	}
}
