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
@Table(name = "social_medias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","curriculaVitae"})
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "linkedin_username")
    private String linkedinUsername;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "curricula_vitae_id")
    private CurriculaVitae curriculaVitae;

}
