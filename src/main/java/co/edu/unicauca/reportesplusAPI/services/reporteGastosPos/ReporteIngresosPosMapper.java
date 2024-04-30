package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.IngresoDTORes;

@Mapper(componentModel = "spring")
public interface ReporteIngresosPosMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "tipo_documento", target = "tipo_documento"),
            @Mapping(source = "numero_movimiento", target = "numero_movimiento"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "cuenta_movimiento", target = "cuenta_movimiento"),
            @Mapping(source = "observacion", target = "observacion"),
            @Mapping(source = "id_tercero", target = "id_tercero"),
            @Mapping(source = "nombre_tercero", target = "nombre_tercero"),
            @Mapping(source = "valor_ejecutado", target = "valor_ejecutado")
    })
    IngresoDTORes ingresoEntityToIngresoDTO(ReporteIngresosPosEntity ingresoEntity);
}
