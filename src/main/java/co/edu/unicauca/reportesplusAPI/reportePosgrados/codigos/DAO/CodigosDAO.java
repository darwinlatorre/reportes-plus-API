package co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO.IngresosEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CodigosDAO {
    private final JdbcTemplate jdbcTemplate;

    public CodigosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CodigosEntity encontrarPosgradoPorCodigo(String codigo) throws SQLException {
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

    public List<CodigosEntity> encontrarTodosLosCodigos() throws SQLException{
        String consultaSQL = "SELECT CODIGO, DESCRIPCION, CODIGO_ALTERNATIVO, ESTADO FROM CODIGOS";
        List<CodigosEntity> listaPosgrados=new ArrayList<>();

        try (PreparedStatement stmt = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .prepareStatement(consultaSQL);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                CodigosEntity posgrado = new CodigosEntity();
                posgrado.setCodigo(resultSet.getString("CODIGO"));
                posgrado.setDescripcion(resultSet.getString("DESCRIPCION"));
                posgrado.setCodigo_alternativo(resultSet.getString("CODIGO_ALTERNATIVO"));
                posgrado.setEstado(resultSet.getString("ESTADO"));
                listaPosgrados.add(posgrado);
            }
        }
        return listaPosgrados;
    }
}
