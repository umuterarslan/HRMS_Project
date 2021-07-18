package com.emin.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {

    private int id;
    private int employerId;
    private int cityId;
    private int jobPositionId;
    private String description;
    private LocalDate expireDate;
    private String partOrFullTime;
    private String remoteOrStandartTyped;
    private int positionCount;
    private int salary;

}
