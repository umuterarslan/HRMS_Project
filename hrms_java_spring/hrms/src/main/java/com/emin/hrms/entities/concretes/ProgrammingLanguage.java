package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programming_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","curriculaVitae"})
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "programming_language_name")
    private String programmingLanguageName;


    @ManyToOne
    @JoinColumn(name = "curricula_vitae_id")
    private CurriculaVitae curriculaVitae;

}
