package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
public class JobPosition {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "jobPosition", cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<JobAdvert> jobAdverts;

}
