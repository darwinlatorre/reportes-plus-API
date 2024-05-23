package co.edu.unicauca.reportesplusAPI.auth;

import java.sql.SQLException;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.reportesplusAPI.auth.DTOs.LoginDTOReq;
import co.edu.unicauca.reportesplusAPI.auth.DTOs.UsuarioDTORes;
import co.edu.unicauca.reportesplusAPI.auth.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/login")
@Tag(name = "Controlador de Autenticación", description = "Operaciones relacionadas con la autenticación de usuarios")
public class authController {

    @Autowired
    private AuthService vAuthService;

    @PostMapping()
    @Operation(summary = "Obtiene un usuario autenticado", description = "Devuelve los datos del usuario si la autenticación es exitosa")
    public ResponseEntity<UsuarioDTORes> obtenerUsuario(@RequestBody LoginDTOReq prmLoginReq) throws SQLException {
        UsuarioDTORes vUser = vAuthService.encontrarUsuario(prmLoginReq.getUsuario(), prmLoginReq.getClave());
        if (vUser != null) {
            return ResponseEntity.ok(vUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
