package com.emin.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers")
public class Employer extends User{

    @Id
    @Column(name="employer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;

    @Column(name="company_name")
    @NonNull
    private String companyName;

    @Column(name="website")
    @NonNull
    private String website;

    @Column(name="phone_number")
    @NonNull
    private String phoneNumber;

}
