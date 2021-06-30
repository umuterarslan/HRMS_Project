package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_adverts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favoriteJobAdvertsForJobseekers"})
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary;

    @Column(name = "position_count")
    private int positionCount;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "release_date")
    private LocalDateTime releaseDate = LocalDateTime.now();

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "is_active")
    private boolean isActive = false;

    @Column(name = "is_confirmed")
    private boolean isConfirmed = false;

    @Column(name = "part_or_full_time")
    private String partOrFullTime;

    @Column(name = "remote_or_standart_typed")
    private String remoteOrStandartTyped;

    @JsonIgnore
    @OneToMany(mappedBy = "jobAdvert", cascade = CascadeType.DETACH)
    private List<FavoriteJobAdvertsForJobseekers> favoriteJobAdvertsForJobseekers;

}
