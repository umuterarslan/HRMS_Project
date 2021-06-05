package com.emin.hrms.entities.concretes;

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

    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @ManyToOne()
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculaVitae")
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculaVitae")
    private List<BusinessLife> businessLifes;

    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "curriculaVitae")
    private List<Technologie> technologies;

}
