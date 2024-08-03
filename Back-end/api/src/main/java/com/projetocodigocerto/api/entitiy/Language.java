package com.projetocodigocerto.api.entitiy;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
//import javax.persistence.Id;

    @Entity
    @Table(name = "language_table")
    public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_language")
    private Long idLanguage;

   // @Column(name = "name_language")
    private String nameLanguage;

        public Language() {
        }

        public Language(Long idLanguage, String nameLanguage) {
            this.idLanguage = idLanguage;
            this.nameLanguage = nameLanguage;
        }

        public Long getIdLanguage() {
            return idLanguage;
        }

        public void setIdLanguage(Long idLanguage) {
            this.idLanguage = idLanguage;
        }

        public String getNameLanguage() {
            return nameLanguage;
        }

        public void setNameLanguage(String nameLanguage) {
            this.nameLanguage = nameLanguage;
        }
    }
