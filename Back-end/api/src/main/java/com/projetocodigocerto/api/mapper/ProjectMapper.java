package com.projetocodigocerto.api.mapper;

import com.projetocodigocerto.api.dto.ProjectDTO;
import com.projetocodigocerto.api.entitiy.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project toModel(ProjectDTO projectDTO);

    ProjectDTO toDTO(Project project);


}
