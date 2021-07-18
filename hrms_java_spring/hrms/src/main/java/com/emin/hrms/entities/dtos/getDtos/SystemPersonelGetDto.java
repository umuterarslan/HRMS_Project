package com.emin.hrms.entities.dtos.getDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonelGetDto {

    private int id;
    private String email;
    private String username;

}
