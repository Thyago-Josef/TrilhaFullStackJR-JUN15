package com.projetocodigocerto.api.repositories;

import com.projetocodigocerto.api.entitiy.Project;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@ComponentScan("com.projetocodigocerto.api.repositories")
public interface ProjectRepository extends JpaRepository<Project,Long> {

}
