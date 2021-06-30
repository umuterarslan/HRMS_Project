package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","curriculaVitae"})
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "technologies")
    private String programmingLanguage;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "curricula_vitae_id")
    private CurriculaVitae curriculaVitae;

}
