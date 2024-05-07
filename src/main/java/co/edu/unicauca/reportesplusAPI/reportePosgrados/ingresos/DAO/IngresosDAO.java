package co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IngresosDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IngresosEntity> findAllIncomeReport() throws SQLException {
        String consultaSQL = "SELECT m.ID, m.MODETIDO, m.MODENUME, m.MODEFECH, m.MODECUMO, m.MODETERC, m.TERCDESC,m.MODEOBSE, m.MODEVALO FROM MOEJ m";
        return jdbcTemplate.query(consultaSQL, new IngresoRowMapper());
    }
}
