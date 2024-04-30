package co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngresoDTORes {
    private Integer id;
    private String tipo_documento;
    private Integer numero_movimiento;
    private Date fecha;
    private String cuenta_movimiento;
    private String observacion;
    private Number id_tercero;
    private String nombre_tercero;
    private Number valor_ejecutado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getNumero_movimiento() {
        return numero_movimiento;
    }

    public void setNumero_movimiento(Integer numero_movimiento) {
        this.numero_movimiento = numero_movimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCuenta_movimiento() {
        return cuenta_movimiento;
    }

    public void setCuenta_movimiento(String cuenta_movimiento) {
        this.cuenta_movimiento = cuenta_movimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Number getId_tercero() {
        return id_tercero;
    }

    public void setId_tercero(Number id_tercero) {
        this.id_tercero = id_tercero;
    }

    public String getNombre_tercero() {
        return nombre_tercero;
    }

    public void setNombre_tercero(String nombre_tercero) {
        this.nombre_tercero = nombre_tercero;
    }

    public Number getValor_ejecutado() {
        return valor_ejecutado;
    }

    public void setValor_ejecutado(Number valor_ejecutado) {
        this.valor_ejecutado = valor_ejecutado;
    }

    @Override
    public String toString() {
        return "IngresoDTO{" +
                "id=" + id +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", numero_movimiento=" + numero_movimiento +
                ", fecha=" + fecha +
                ", cuenta_movimiento='" + cuenta_movimiento + '\'' +
                ", observacion='" + observacion + '\'' +
                ", id_tercero=" + id_tercero +
                ", nombre_tercero='" + nombre_tercero + '\'' +
                ", valor_ejecutado=" + valor_ejecutado +
                '}';
    }
}
