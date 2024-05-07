package co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IngresoRowMapper implements RowMapper<IngresosEntity> {

    @Override
    public IngresosEntity mapRow(ResultSet resultSet, int rowInt) throws SQLException {

        IngresosEntity IngresosEntity = new IngresosEntity();
        IngresosEntity.setId((resultSet.getInt("ID")));
        IngresosEntity.setTipo_documento(resultSet.getString("MODETIDO"));
        IngresosEntity.setNumero_movimiento(resultSet.getInt("MODENUME"));
        IngresosEntity.setFecha(resultSet.getDate("MODEFECH"));
        IngresosEntity.setCuenta_movimiento(resultSet.getString("MODECUMO"));
        IngresosEntity.setObservacion(resultSet.getString("MODEOBSE"));
        IngresosEntity.setId_tercero(resultSet.getDouble("MODETERC"));
        IngresosEntity.setNombre_tercero(resultSet.getString("TERCDESC"));
        IngresosEntity.setValor_ejecutado(resultSet.getDouble("MODEVALO"));

        return IngresosEntity;
    }
}
