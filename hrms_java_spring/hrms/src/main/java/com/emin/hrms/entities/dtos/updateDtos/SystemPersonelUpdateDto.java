package com.emin.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonelUpdateDto {

    private int id;
    private String email;
    private String username;

}
