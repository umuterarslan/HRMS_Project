package com.emin.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "system_personels")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class SystemPersonel extends User {

    @Column(name = "username")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private String username;

}
