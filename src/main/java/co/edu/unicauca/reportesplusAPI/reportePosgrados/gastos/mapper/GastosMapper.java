package co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DAO.GastoEntity;
import co.edu.unicauca.reportesplusAPI.reportePosgrados.gastos.DTOs.GastoDTORes;

@Mapper(componentModel = "spring")
public interface GastosMapper {

        GastoDTORes gastoEntityToGastoDTO(GastoEntity gastoEntity);

        List<GastoDTORes> gastoEntityListAGastoDTOResList(List<GastoEntity> gastoEntityList);
}
