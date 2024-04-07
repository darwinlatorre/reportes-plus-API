package co.edu.unicauca.reportesplusAPI.services.reporteGastosPos;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface ReporteGastosPosMapper {

    @Mappings({
            @Mapping(source="ID", target="ID"),
            @Mapping(target = "tipo_documento", source = "tipo_documento"),
            @Mapping(target = "numero_movimiento", source = "numero_movimiento"),
            @Mapping(target = "fecha", source = "fecha"),
            @Mapping(target = "cuenta_movimiento", source = "cuenta_movimiento"),
            @Mapping(target = "observacion", source = "observacion"),
            @Mapping(target = "valor_definitivo", source = "valor_definitivo"),
            @Mapping(target = "valor_registro", source = "valor_registro"),
            @Mapping(target = "valor_ejecutado", source = "valor_ejecutado"),
            @Mapping(target = "valor_pagado", source = "valor_pagado"),
            @Mapping(target = "saldo", source = "saldo"),
            @Mapping(target = "estado", source = "estado")
    })

    GastoDTORes gastoEntityToGastoDTO(ReporteGastosPosEntity gastoEntity);
}
