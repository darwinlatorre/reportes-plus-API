package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;

@Mapper(componentModel = "spring")
public interface GastosMapper {

    @Mappings({
            @Mapping(source = "ID", target = "ID"),
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

    GastoDTORes gastoEntityToGastoDTO(GastoEntity gastoEntity);

    @IterableMapping(elementTargetType = GastoDTORes.class)
    List<GastoDTORes> gastoEntityListToGastoDTOResList(List<GastoEntity> gastoEntityList);

}
