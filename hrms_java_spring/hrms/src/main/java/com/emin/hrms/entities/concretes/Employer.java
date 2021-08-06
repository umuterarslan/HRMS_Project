package com.emin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employerChangeRequests"})
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @Column(name = "picture_url")
    private String pictureUrl = "https://i.ibb.co/D5nfGGh/Person-595b40b75ba036ed117da139.png";

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "req_flag")
    private boolean reqFlag = false;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<JobAdvert> jobAdverts;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<EmployerUpdateRequest> employerUpdateRequests;

}
