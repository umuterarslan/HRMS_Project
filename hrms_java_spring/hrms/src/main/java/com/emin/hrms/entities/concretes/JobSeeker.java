package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobseekers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","curriculaVitaes, favoriteJobAdvertsForJobseekers"})
public class JobSeeker extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    private List<CurriculaVitae> curriculaVitaes;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    private List<FavoriteJobAdvertsForJobseekers> favoriteJobAdvertsForJobseekers;

}
