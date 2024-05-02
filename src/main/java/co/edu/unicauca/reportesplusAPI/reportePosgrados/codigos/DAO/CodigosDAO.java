package co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CodigosDAO {
    private final JdbcTemplate jdbcTemplate;

    public CodigosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CodigosEntity encontrarPorCodigo(String codigo) throws SQLException {
        String consultaSQL = "SELECT CODIGO, DESCRIPCION, CODIGO_ALTERNATIVO, ESTADO FROM CODIGOS WHERE CODIGO = ?";

        CodigosEntity posgrado = new CodigosEntity();

        try (PreparedStatement declaracionSQL = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .prepareStatement(consultaSQL)) {

            declaracionSQL.setString(1, codigo);

            try (ResultSet resultSet = declaracionSQL.executeQuery()) {
                resultSet.next();
                posgrado.setCodigo(resultSet.getString("CODIGO"));
                posgrado.setDescripcion(resultSet.getString("DESCRIPCION"));
                posgrado.setCodigo_alternativo(resultSet.getString("CODIGO_ALTERNATIVO"));
                posgrado.setEstado(resultSet.getString("ESTADO"));
                resultSet.close();
            }
            declaracionSQL.close();
        }
        return posgrado;
    }

}
