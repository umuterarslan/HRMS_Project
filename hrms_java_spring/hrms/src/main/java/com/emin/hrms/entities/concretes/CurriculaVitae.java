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
    @JoinColumn(name = "education_id")
    private Education education;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeeker> jobSeekers;

    @ManyToOne
    @JoinColumn(name = "business_life_id")
    private BusinessLife businessLife;

    @ManyToOne
    @JoinColumn(name = "jobseeker_language_id")
    private JobseekerLanguage jobseekerLanguage;

    @ManyToOne
    @JoinColumn(name = "programming_language_id")
    private ProgrammingLanguage programmingLanguage;

    @ManyToOne
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @ManyToOne
    @JoinColumn(name = "jobseeker_picture_id")
    private JobseekerPicture jobseekerPicture;

}
