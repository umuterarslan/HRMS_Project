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
@Table(name = "favorite_job_adverts_for_jobseekers")
public class FavoriteJobAdvertsForJobseekers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "job_advert_id")
    private JobAdvert jobAdvert;

}
