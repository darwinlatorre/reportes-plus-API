package co.edu.unicauca.reportesplusAPI.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_REPORTE_GASTOS")
@Schema(description = "Entidad que representa un reporte de posgrados")
public class ReporteGastosModel {

    // RECORDATORIO: Siempre documentar cada atributo de la clase-entidad - Swagger
    // EJEMPLO
    /**
     * Identificador único.
     *
     */
    @Id
    private Integer ID;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "TITULO",length = 50)
    private  String titulo;

    @Column(name = "NOMBRE",length = 50)
    private  String nombre;

    @Column(name = "EMPRESA",length = 2)
    private String empresa;

    @Column(name = "TIPODCTO",length = 10)
    private String tipoDcto;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "SECUENCIA")
    private  Integer secuencia;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "CUENTAMOVIMIENTO",length = 50)
    private  String cuentaMovimiento;

    @Column(name = "DESTINO",length = 10)
    private  String destino;

    @Column(name = "CENTROINFORMACION",length = 10)
    private  String centroInformacion;

    @Column(name = "TIPOMOVIMIENTO",length = 10)
    private  String tipoMovimiento;

    @Column(name = "OBSERVACCION",length = 500)
    private  String observacion;

    @Column(name = "VALORINICIAL")
    private  double valorInicial;

    @Column(name = "VALORAJUSTEDEBITO")
    private double valoraJusteDebito;

    @Column(name = "VALORAJUSTECREDITO")
    private  double valoraJusteCredito;

    @Column(name = "VALORDEFINITIVO")
    private  double valorDefinitivo;

    @Column(name = "VALORREGISTROS")
    private  double valorRegistros;

    @Column(name = "VALOREJECUTADO")
    private  double valorEjecutado;

    @Column(name = "VALORPAGADO")
    private  double valorPagado;

    @Column(name = "SALDO")
    private double saldo;

    @Column(name = "ESTADO",length = 2)
    private  String estado;
}
