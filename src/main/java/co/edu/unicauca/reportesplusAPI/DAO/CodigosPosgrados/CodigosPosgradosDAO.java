package co.edu.unicauca.reportesplusAPI.DAO.CodigosPosgrados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CodigosPosgradosDAO {
    private final JdbcTemplate jdbcTemplate;

    public CodigosPosgradosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CodigosPosgradosEntity> findAllCodes() throws SQLException {
        String sql = "SELECT m.CODIGO,m.DESCRIPCION,m.CODIGO_ALTERNATIVO,m.ESTADO FROM CODIGOS m";
        List<CodigosPosgradosEntity> posgrados = new ArrayList<>();

        try (PreparedStatement stmt = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CodigosPosgradosEntity posgrado = new CodigosPosgradosEntity();
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
