package co.edu.unicauca.reportesplusAPI.auth.DAO;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDao {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UsuarioEntity findUser(String user) throws SQLException {
        String consultaSQL = "SELECT u.CODIGO,u.usuario,u.clave,u.nombre, u.correo FROM Usuarios u where u.USUARIO = ?";
        return jdbcTemplate.queryForObject(consultaSQL, new UsuarioRowMapper(), user);
    }
}
