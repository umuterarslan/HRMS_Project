package com.emin.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateDto {

    private int id;
    private String email;
    private String companyName;
    private String website;
    private String phoneNumber;

}
