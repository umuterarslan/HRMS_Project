package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "business_lifes")
public class BusinessLife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "bl_start_date")
    @NotNull
    @NotBlank
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonIgnore
    @OneToMany(mappedBy = "businessLife")
    private List<CurriculaVitae> curriculaVitaes;

}
