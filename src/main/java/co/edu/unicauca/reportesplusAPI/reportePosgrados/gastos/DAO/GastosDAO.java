package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GastosDAO {

	private final JdbcTemplate jdbcTemplate;

	public GastosDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<GastoEntity> encontrarReportesPorFechaYCódigo(Date fechaInicio, Date fechaFin, String codigo)
			throws SQLException {

		String consultaSQL = "SELECT m.ID, m.MOCDCDTD, m.MOCDCDND, m.MOCDFECH, m.MOCDCUMO, m.MOCDOBSE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDESTA FROM MOCD m WHERE m.MOCDFECH BETWEEN ? AND ? AND SUBSTR(m.MOCDCUMO, INSTR(m.MOCDCUMO, '.', -1) + 1) = ?";

		List<GastoEntity> GastoEntityList = new ArrayList<>();

		try (PreparedStatement declaracionSQL = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
				.prepareStatement(consultaSQL)) {

			System.out.println(fechaInicio);
			System.out.println(fechaFin);

			declaracionSQL.setDate(1, fechaInicio);
			declaracionSQL.setDate(2, fechaFin);
			declaracionSQL.setString(3, codigo);

			ResultSet resultSet = declaracionSQL.executeQuery();

			while (resultSet.next()) {
				GastoEntity gastoEntity = new GastoEntity();

				gastoEntity.setID(resultSet.getInt("ID"));
				gastoEntity.setTipo_documento(resultSet.getString("MOCDCDTD"));
				gastoEntity.setNumero_movimiento(resultSet.getInt("MOCDCDND"));
				gastoEntity.setFecha(resultSet.getDate("MOCDFECH"));
				gastoEntity.setCuenta_movimiento(resultSet.getString("MOCDCUMO"));
				gastoEntity.setObservacion(resultSet.getString("MOCDOBSE"));
				gastoEntity.setValor_definitivo(resultSet.getBigDecimal("MOCDVADE"));
				gastoEntity.setValor_registro(resultSet.getBigDecimal("MOCDVADE"));
				gastoEntity.setValor_ejecutado(resultSet.getBigDecimal("MOCDVADE"));
				gastoEntity.setValor_pagado(resultSet.getBigDecimal("MOCDVADE"));
				gastoEntity.setSaldo(resultSet.getBigDecimal("MOCDVADE"));
				gastoEntity.setEstado(resultSet.getString("MOCDESTA"));

				GastoEntityList.add(gastoEntity);
			}

			resultSet.close();
			declaracionSQL.close();
		}
		return GastoEntityList;
	}
}
