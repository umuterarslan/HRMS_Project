package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","curriculaVitae"})
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "education_start_date")
    @NotNull
    @NotBlank
    private LocalDate startDate;

    @Column(name = "end_date")
    @NotNull
    @NotBlank
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "curricula_vitae_id")
    private CurriculaVitae curriculaVitae;

}
