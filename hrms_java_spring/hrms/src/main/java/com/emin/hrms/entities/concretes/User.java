package com.emin.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users" , uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="password")
    @NotNull
    private String password;

}
