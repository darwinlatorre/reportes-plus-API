package co.edu.unicauca.reportesplusAPI.auth.DTOs;

import lombok.Getter;
import lombok.Setter;

public class LoginDTOReq {

    private String usuario;
    private String clave;

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


}