package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GastoRowMapper implements RowMapper<GastoEntity> {

    @Override
    public GastoEntity mapRow(ResultSet resultSet, int rowInt) throws SQLException {

        GastoEntity gastoEntity = new GastoEntity();

        gastoEntity.setID(resultSet.getInt("ID"));
        gastoEntity.setTipo_documento(resultSet.getString("MOCDCDTD"));
        gastoEntity.setNumero_movimiento(resultSet.getInt("MOCDCDND"));
        gastoEntity.setFecha(resultSet.getDate("MOCDFECH"));
        gastoEntity.setCuenta_movimiento(resultSet.getString("MOCDCUMO"));
        gastoEntity.setObservacion(resultSet.getString("MOCDOBSE"));
        gastoEntity.setValor_definitivo(resultSet.getBigDecimal("MOCDVADE"));
        gastoEntity.setValor_registro(resultSet.getBigDecimal("MOCDVADE"));
        gastoEntity.setValor_ejecutado(resultSet.getBigDecimal("MOCDVADE"));
        gastoEntity.setValor_pagado(resultSet.getBigDecimal("MOCDVADE"));
        gastoEntity.setSaldo(resultSet.getBigDecimal("MOCDVADE"));
        gastoEntity.setEstado(resultSet.getString("MOCDESTA"));

        return gastoEntity;
    }
}
