package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GastoDAO {

	private JdbcTemplate JdbcTemplate;

	@Autowired
	private void setJdbcTemplate(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}

	public List<GastoEntity> encontrarReportesPorFechaYCodigo(Date fechaInicio, Date fechaFin, String codigo)
			throws SQLException {
		String consultaSQL = "SELECT m.ID, m.MOCDCDTD, m.MOCDCDND, m.MOCDFECH, m.MOCDCUMO, m.MOCDOBSE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDESTA FROM MOCD m WHERE m.MOCDFECH BETWEEN ? AND ? AND SUBSTR(m.MOCDCUMO, INSTR(m.MOCDCUMO, '.', -1) + 1) = ?";
		return JdbcTemplate.query(consultaSQL, new GastoRowMapper(), fechaInicio, fechaFin, codigo);
	}
}