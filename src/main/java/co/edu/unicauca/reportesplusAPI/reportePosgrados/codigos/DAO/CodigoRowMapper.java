package co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CodigoRowMapper implements RowMapper<CodigoEntity> {

    @Override
    public CodigoEntity mapRow(ResultSet resultSet, int rowInt) throws SQLException {

        CodigoEntity CodigosEntity = new CodigoEntity();

        CodigosEntity.setCodigo(resultSet.getString("CODIGO"));
        CodigosEntity.setDescripcion(resultSet.getString("DESCRIPCION"));
        CodigosEntity.setCodigo_alternativo(resultSet.getString("CODIGO_ALTERNATIVO"));
        CodigosEntity.setEstado(resultSet.getString("ESTADO"));

        return CodigosEntity;
    }
}
