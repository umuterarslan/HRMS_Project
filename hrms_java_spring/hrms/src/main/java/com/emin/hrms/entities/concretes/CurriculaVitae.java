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
@PrimaryKeyJoinColumn(name="id")
public class CurriculaVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @NotBlank
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "picture_url")
    private String pictureUrl = "https://i.ibb.co/D5nfGGh/Person-595b40b75ba036ed117da139.png";

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<BusinessLife> businessLifes;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<Technology> technologies;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<SocialMedia> socialMedias;
}
