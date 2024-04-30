package co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteIngresosPosEntity {
    private Integer id;
    private String tipo_documento;
    private Integer numero_movimiento;
    private Date fecha;
    private String cuenta_movimiento;
    private String observacion;
    // FIXME: categoria aparece en el diagrama pero no en la bd.
    // private String categoria;
    private Number id_tercero;
    private String nombre_tercero;
    private Number valor_ejecutado;

    // Getter para id
    public Integer getId() {
        return id;
    }

    // Setter para id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter para tipo_documento
    public String getTipo_documento() {
        return tipo_documento;
    }

    // Setter para tipo_documento
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    // Getter para numero_movimiento
    public Integer getNumero_movimiento() {
        return numero_movimiento;
    }

    // Setter para numero_movimiento
    public void setNumero_movimiento(Integer numero_movimiento) {
        this.numero_movimiento = numero_movimiento;
    }

    // Getter para fecha
    public Date getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter para cuenta_movimiento
    public String getCuenta_movimiento() {
        return cuenta_movimiento;
    }

    // Setter para cuenta_movimiento
    public void setCuenta_movimiento(String cuenta_movimiento) {
        this.cuenta_movimiento = cuenta_movimiento;
    }

    // Getter para observacion
    public String getObservacion() {
        return observacion;
    }

    // Setter para observacion
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    // Getter para id_tercero
    public Number getId_tercero() {
        return id_tercero;
    }

    // Setter para id_tercero
    public void setId_tercero(Number id_tercero) {
        this.id_tercero = id_tercero;
    }

    // Getter para nombre_tercero
    public String getNombre_tercero() {
        return nombre_tercero;
    }

    // Setter para nombre_tercero
    public void setNombre_tercero(String nombre_tercero) {
        this.nombre_tercero = nombre_tercero;
    }

    // Getter para valor_ejecutado
    public Number getValor_ejecutado() {
        return valor_ejecutado;
    }

    // Setter para valor_ejecutado
    public void setValor_ejecutado(Number valor_ejecutado) {
        this.valor_ejecutado = valor_ejecutado;
    }

    @Override
    public String toString() {
        return "ReporteGastosPosEntity{" +
                "ID=" + id +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", numero_movimiento=" + numero_movimiento +
                ", fecha=" + fecha +
                ", cuenta_movimiento='" + cuenta_movimiento + '\'' +
                ", observacion='" + observacion + '\'' +
                ", id_tercero=" + id_tercero +
                ", nombre_tercero=" + nombre_tercero +
                ", valor_ejecutado=" + valor_ejecutado +
                '\'' +
                '}';
    }
}
