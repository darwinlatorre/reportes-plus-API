package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;


import co.edu.unicauca.reportesplusAPI.DAO.usuarios.UsuarioEntity;
import co.edu.unicauca.reportesplusAPI.dtos.usuarioSimca.UsuarioDTORes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "codigo",target = "codigo"),
            @Mapping(source = "usuario",target = "usuario"),
            @Mapping(source = "clave",target = "clave"),
            @Mapping(source = "nombre",target = "nombre"),
            @Mapping(source = "correo",target = "correo")
    })
    UsuarioDTORes usuarioEntityToUsuarioDTO(UsuarioEntity usuarioEntity);
}
