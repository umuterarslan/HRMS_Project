package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curricula_vitaes")
public class CurriculaVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @NotBlank
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @ManyToOne
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeeker> jobSeekers;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<Education> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<BusinessLife> businessLifes;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobseekerLanguage> jobseekerLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobseekerPicture> jobseekerPictures;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<ProgrammingLanguage> programmingLanguages;

}
