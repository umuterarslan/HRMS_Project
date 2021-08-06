package com.emin.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateRequestAddDto {

    private int id;
    private int employerId;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String website;

}
