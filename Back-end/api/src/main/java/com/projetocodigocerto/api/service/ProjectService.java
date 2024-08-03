package com.projetocodigocerto.api.service;

import com.projetocodigocerto.api.dto.LanguageDTO;
import com.projetocodigocerto.api.dto.ProjectDTO;
import com.projetocodigocerto.api.dto.response.MessageResponseDTO;
import com.projetocodigocerto.api.entitiy.Language;
import com.projetocodigocerto.api.entitiy.Project;
import com.projetocodigocerto.api.exception.ProjectNotFoundException;
import com.projetocodigocerto.api.mapper.LanguageMapper;
import com.projetocodigocerto.api.mapper.ProjectMapper;
import com.projetocodigocerto.api.repositories.LanguageRepository;
import com.projetocodigocerto.api.repositories.ProjectRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProjectService {

    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final LanguageRepository languageRepository;


    private  ProjectMapper projectMapper = ProjectMapper.INSTANCE;

    private  LanguageMapper languageMapper = LanguageMapper.INSTANCE;


    public MessageResponseDTO createProject(ProjectDTO projectDTO) {

        Project projectToSave = projectMapper.toModel(projectDTO);
        Project projectSaved = projectRepository.save(projectToSave);
        return createMessageResponse( projectSaved.getId_project(), "Projeto criado com sucesso!");
    }

    public LanguageDTO adcionarNovaLinguagem(LanguageDTO languageDTO)  {
        Language languageToSave = languageMapper.toModel(languageDTO);
        Language languageSaved = languageRepository.save(languageToSave);
        return languageMapper.toDTO(languageSaved);
    }

    //Retornar todas as pessoas
    public List<ProjectDTO> listAll(){
        List<Project> allProject = projectRepository.findAll();
        return allProject.stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProjectDTO findById(Long id) throws ProjectNotFoundException {
        Project project = verifyIfExists(id);

        return projectMapper.toDTO(project);
    }


    public MessageResponseDTO deleteById(Long id) throws ProjectNotFoundException {
        verifyIfExists(id);

        projectRepository.deleteById(id);
        return createMessageResponse(id, "Deleted person with ID ");
    }

    public MessageResponseDTO updateById(Long id, ProjectDTO projectDTO) throws ProjectNotFoundException {
        verifyIfExists(id);

        Project projectToUpdate = projectMapper.toModel(projectDTO);
        projectToUpdate.setId_project(id);

        Project updatedProject = projectRepository.save(projectToUpdate);

        return createMessageResponse(updatedProject.getId_project(), "Updated person with ID ");
    }


    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }


    private Project verifyIfExists(Long id) throws ProjectNotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

public ProjectDTO adcionarLinguagem(Long id, LanguageDTO languageDTO) throws ProjectNotFoundException {

        Language languageToAdd = languageMapper.toModel(languageDTO);

        verifyIfExistsLanguage(languageToAdd.getIdLanguage());

        Project project = verifyIfExists(id);

        project.getLanguages().add(languageToAdd);

        projectRepository.save(project);

        return projectMapper.toDTO(project);
}





private  Language verifyIfExistsLanguage(Long id) throws ProjectNotFoundException {
    return languageRepository.findById(id)
            .orElseThrow(() -> new ProjectNotFoundException(id));
}
    
}
