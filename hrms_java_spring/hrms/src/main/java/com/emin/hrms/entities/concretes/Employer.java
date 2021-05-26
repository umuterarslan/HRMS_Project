package com.emin.hrms.entities.concretes;

import com.sun.istack.NotNull;
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
    @NotNull
    private int id;

    @Column(name="company_name")
    @NotNull
    private String companyName;

    @Column(name="website")
    @NotNull
    private String website;

    @Column(name="phone_number")
    @NotNull
    private String phoneNumber;

    @NotNull
    private String confirmPassword;

}
