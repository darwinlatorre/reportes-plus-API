package co.edu.unicauca.reportesplusAPI.auth.service;
import co.edu.unicauca.reportesplusAPI.auth.DAO.UsuarioDao;
import co.edu.unicauca.reportesplusAPI.auth.DAO.UsuarioEntity;
import co.edu.unicauca.reportesplusAPI.auth.DTOs.UsuarioDTORes;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.ingresos.DAO.IngresosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import java.sql.SQLException;
import java.util.List;


@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UsuarioDao DAO;


    @Override
    public UsuarioDTORes encontrarUsuario(String Usuario, String Contrasenia) throws SQLException {
        UsuarioEntity userSimca = DAO.findUser(Usuario);
        if (userSimca != null) {
            String contraseniaFromBd = userSimca.getClave();
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(Contrasenia.getBytes("UTF-8"));
                StringBuilder hexString = new StringBuilder();

                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                String contraseniaCifrada = hexString.toString();
                if (contraseniaCifrada.equals(contraseniaFromBd)) {
                    UsuarioDTORes usuarioDTO = new UsuarioDTORes();
                    usuarioDTO.setCodigo(userSimca.getCodigo());
                    usuarioDTO.setUsuario(userSimca.getUsuario());
                    usuarioDTO.setClave(contraseniaCifrada);
                    usuarioDTO.setNombre(userSimca.getNombre());
                    usuarioDTO.setCorreo(userSimca.getCorreo());
                    return usuarioDTO;
                } else {
                    return null;
                }
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
