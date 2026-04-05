package com.bugpetconsumer.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bugpetconsumer.project.dto.DiedPetDto;
import com.bugpetconsumer.project.entity.DiedPet;

@Mapper(componentModel = "spring")
public interface DiedPetMapper {

    @Mapping(target = "id", ignore = true)
    DiedPet toEntity(DiedPetDto dto);

    @Mapping(target = "id", source = "id")
    DiedPetDto toDto(DiedPet entity);
}
