package com.emin.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="system_personel" , uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class SystemPersonel extends User{

    @Id
    @Column(name="personel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name="username")
    @NotNull
    private String username;

}
