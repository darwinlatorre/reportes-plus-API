package co.edu.unicauca.reportesplusAPI.reportePosgrados.codigos.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodigoEntity {
    private String codigo;
    private String descripcion;
    private String codigo_alternativo;
    private String estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_alternativo() {
        return codigo_alternativo;
    }

    public void setCodigo_alternativo(String codigo_alternativo) {
        this.codigo_alternativo = codigo_alternativo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
