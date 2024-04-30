package co.edu.unicauca.reportesplusAPI.reportePosgrados.common.DAOCodigosPosgrados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CodigosDAO {
    private final JdbcTemplate jdbcTemplate;

    public CodigosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CodigosEntity> findAllCodes() throws SQLException {
        String sql = "SELECT m.CODIGO,m.DESCRIPCION,m.CODIGO_ALTERNATIVO,m.ESTADO FROM CODIGOS m";
        List<CodigosEntity> posgrados = new ArrayList<>();

        try (PreparedStatement stmt = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CodigosEntity posgrado = new CodigosEntity();
                posgrado.setCodigo((rs.getString("CODIGO")));
                posgrado.setDescripcion((rs.getString("DESCRIPCION")));
                posgrado.setCodigo_alternativo((rs.getString("CODIGO_ALTERNATIVO")));
                posgrado.setEstado((rs.getString("ESTADO")));
                posgrados.add(posgrado);
            }
        }
        return posgrados;
    }
}
