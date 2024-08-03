package com.projetocodigocerto.api.mapper;

import com.projetocodigocerto.api.dto.LanguageDTO;
import com.projetocodigocerto.api.entitiy.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers .getMapper(LanguageMapper.class);

    LanguageDTO toDTO(Language language);

    Language toModel(LanguageDTO languageDTO);
}
