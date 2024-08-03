package com.projetocodigocerto.api.repositories;

import com.projetocodigocerto.api.entitiy.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@Component("com.projetocodigocerto.api.repositories")
public interface LanguageRepository  extends JpaRepository<Language, Long> {


    @Query("SELECT l FROM Language l WHERE l.nameLanguage = :name")
    List<Language> findByNameLanguage(String name);

}
