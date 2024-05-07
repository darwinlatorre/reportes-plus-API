package co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CodigosDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CodigoEntity encontrarPosgradoPorCodigo(String codigo) throws SQLException {
        String consultaSQL = "SELECT CODIGO, DESCRIPCION, CODIGO_ALTERNATIVO, ESTADO FROM CODIGOS WHERE CODIGO = ?";
        return jdbcTemplate.queryForObject(consultaSQL, new CodigoRowMapper(), codigo);
    }

    public List<CodigoEntity> encontrarTodosLosCodigos() throws SQLException {
        String consultaSQL = "SELECT CODIGO, DESCRIPCION, CODIGO_ALTERNATIVO, ESTADO FROM CODIGOS";
        return jdbcTemplate.query(consultaSQL, new CodigoRowMapper());
    }
}
