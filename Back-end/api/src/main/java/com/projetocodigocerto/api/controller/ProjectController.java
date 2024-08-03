package com.projetocodigocerto.api.controller;

import com.projetocodigocerto.api.dto.LanguageDTO;
import com.projetocodigocerto.api.dto.ProjectDTO;
import com.projetocodigocerto.api.dto.response.MessageResponseDTO;
import com.projetocodigocerto.api.exception.ProjectNotFoundException;
import com.projetocodigocerto.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }


    @GetMapping
    public List<ProjectDTO> listAll() {
        return projectService.listAll();
    }

    //Listar uma pessoa
    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Long id) throws ProjectNotFoundException {
        return projectService.findById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ProjectNotFoundException {
        projectService.deleteById(id);
    }


    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ProjectDTO projectDTO) throws ProjectNotFoundException {
        return projectService.updateById(id, projectDTO);
    }


    @PostMapping("/{id}/language")
    public ProjectDTO adcionarLinguagem(@PathVariable Long id, @RequestBody @Valid LanguageDTO languageDTO) throws ProjectNotFoundException {
        return projectService.adcionarLinguagem(id, languageDTO);
    }
    @PostMapping("/language")
    public LanguageDTO adcionarLinguagem2(@RequestBody @Valid LanguageDTO languageDTO) throws ProjectNotFoundException {
        return projectService.adcionarNovaLinguagem(languageDTO);
    }
}
