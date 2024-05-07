package co.edu.unicauca.reportesplusAPI.auth;

import co.edu.unicauca.reportesplusAPI.auth.DTOs.LoginDTOReq;
import co.edu.unicauca.reportesplusAPI.auth.DTOs.UsuarioDTORes;
import co.edu.unicauca.reportesplusAPI.auth.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/login")
@Tag(name = "Controlador de inicio de sesion", description = "Endpoint que verifica si el inicio de sesion ha sido correcto.")
public class authController {

    @Autowired
    private AuthService vAuthService;

    @PostMapping()
    public ResponseEntity<UsuarioDTORes> obtenerUsuario(@RequestBody LoginDTOReq prmLoginReq) throws SQLException {
        UsuarioDTORes vUser = vAuthService.encontrarUsuario(prmLoginReq.getUsuario(), prmLoginReq.getClave());
        if(vUser!=null){
            return ResponseEntity.ok(vUser);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
