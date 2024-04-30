package co.edu.unicauca.reportesplusAPI.DAO.usuarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "SELECT u.CODIGO,u.usuario,u.clave,u.nombre, u.correo FROM Usuarios u where u.USUARIO = ?";
        UsuarioEntity userSimca = new UsuarioEntity();
        try (PreparedStatement stmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql)) {
            stmt.setString(1, user);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    userSimca = new UsuarioEntity();
                    userSimca.setCodigo(rs.getString("CODIGO"));
                    userSimca.setUsuario(rs.getString("USUARIO"));
                    userSimca.setClave(rs.getString("CLAVE"));
                    userSimca.setNombre(rs.getString("NOMBRE"));
                    userSimca.setCorreo(rs.getString("CORREO"));
                }
            }
        }
        return userSimca;
    }
}
