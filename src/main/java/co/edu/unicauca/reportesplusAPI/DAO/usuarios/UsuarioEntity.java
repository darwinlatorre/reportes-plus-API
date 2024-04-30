package co.edu.unicauca.reportesplusAPI.DAO.usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    private String codigo;
    private String usuario;
    private String clave;
    private String nombre;
    private  String correo;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "ReporteGastosPosEntity{" +
                "Codigo= " + codigo+
                ", Usuario= '" + usuario+ '\'' +
                ", clave=" + clave+
                ", nombre= " + nombre +
                ", correo= '" + correo + '\'' +
                '\'' +
                '}';
    }
}
