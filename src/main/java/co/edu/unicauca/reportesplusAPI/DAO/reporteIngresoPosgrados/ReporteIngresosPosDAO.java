package co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReporteIngresosPosDAO {

    private final JdbcTemplate jdbcTemplate;

    public ReporteIngresosPosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ReporteIngresosPosEntity> findAllIncomeReport() throws SQLException {

        String sql = "SELECT m.ID, m.MODETIDO, m.MODENUME, m.MODEFECH, m.MODECUMO, m.MODETERC, m.TERCDESC,m.MODEOBSE, m.MODEVALO FROM MOEJ m";

        List<ReporteIngresosPosEntity> reportes = new ArrayList<>();

        try (PreparedStatement stmt = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ReporteIngresosPosEntity reporte = new ReporteIngresosPosEntity();
                reporte.setId((rs.getInt("ID")));
                reporte.setTipo_documento(rs.getString("MODETIDO"));
                reporte.setNumero_movimiento(rs.getInt("MODENUME"));
                reporte.setFecha(rs.getDate("MODEFECH"));
                reporte.setCuenta_movimiento(rs.getString("MODECUMO"));
                reporte.setObservacion(rs.getString("MODEOBSE"));
                reporte.setId_tercero(rs.getDouble("MODETERC"));
                reporte.setNombre_tercero(rs.getString("TERCDESC"));
                reporte.setValor_ejecutado(rs.getDouble("MODEVALO"));
                reportes.add(reporte);
            }
        }
        return reportes;
    }

}
