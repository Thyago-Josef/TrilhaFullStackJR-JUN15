package com.projetocodigocerto.api.dto;

import com.projetocodigocerto.api.entitiy.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id_project;

    private String name_project;

    private String description_project;

    private Date date_project;

    private Set<LanguageDTO> languages = new HashSet<>();



}


