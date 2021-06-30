package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<JobAdvert> jobAdverts;

}
