package co.edu.unicauca.reportesplusAPI.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.unicauca.reportesplusAPI.auth.DAO.UsuarioEntity;
import co.edu.unicauca.reportesplusAPI.auth.DTOs.UsuarioDTORes;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "codigo"),
            @Mapping(source = "usuario", target = "usuario"),
            @Mapping(source = "clave", target = "clave"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "correo", target = "correo")
    })
    UsuarioDTORes usuarioEntityToUsuarioDTO(UsuarioEntity usuarioEntity);
}
