package co.edu.unicauca.reportesplusAPI.auth.service;
import co.edu.unicauca.reportesplusAPI.auth.DTOs.UsuarioDTORes;

import java.sql.SQLException;


public interface AuthService {
    public UsuarioDTORes encontrarUsuario(String Usuario, String Contrasenia) throws SQLException;
}
