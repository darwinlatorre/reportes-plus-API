package co.edu.unicauca.reportesplusAPI.auth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioRowMapper implements RowMapper<UsuarioEntity> {

    @Override
    public UsuarioEntity mapRow(ResultSet resultSet, int rowInt) throws SQLException {
        UsuarioEntity userSimca = new UsuarioEntity();
        userSimca.setCodigo(resultSet.getString("CODIGO"));
        userSimca.setUsuario(resultSet.getString("USUARIO"));
        userSimca.setClave(resultSet.getString("CLAVE"));
        userSimca.setNombre(resultSet.getString("NOMBRE"));
        userSimca.setCorreo(resultSet.getString("CORREO"));
        return userSimca;
    }

}
