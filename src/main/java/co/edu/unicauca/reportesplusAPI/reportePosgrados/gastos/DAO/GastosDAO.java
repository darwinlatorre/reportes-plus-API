package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GastosDAO {

    private final JdbcTemplate jdbcTemplate;

    public GastosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GastosEntity> findAllExpenseReport() throws SQLException {
        String sql = "SELECT m.ID, m.MOCDCDTD, m.MOCDCDND, m.MOCDFECH, m.MOCDCUMO, m.MOCDOBSE, m.MOCDVADE,m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDVADE, m.MOCDESTA FROM MOCD m";
        List<GastosEntity> reportes = new ArrayList<>();

        try (PreparedStatement stmt = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GastosEntity reporte = new GastosEntity();
                reporte.setID((rs.getInt("ID")));
                reporte.setTipo_documento(rs.getString("MOCDCDTD"));
                reporte.setNumero_movimiento(rs.getInt("MOCDCDND"));
                reporte.setFecha(rs.getDate("MOCDFECH"));
                reporte.setCuenta_movimiento(rs.getString("MOCDCUMO"));
                reporte.setObservacion(rs.getString("MOCDOBSE"));
                reporte.setValor_definitivo(rs.getDouble("MOCDVADE"));
                reporte.setValor_registro(rs.getDouble("MOCDVADE"));
                reporte.setValor_ejecutado(rs.getDouble("MOCDVADE"));
                reporte.setValor_pagado(rs.getDouble("MOCDVADE"));
                reporte.setSaldo(rs.getDouble("MOCDVADE"));
                reporte.setEstado(rs.getString("MOCDESTA"));
                reportes.add(reporte);
            }
        }
        return reportes;
    }

}
