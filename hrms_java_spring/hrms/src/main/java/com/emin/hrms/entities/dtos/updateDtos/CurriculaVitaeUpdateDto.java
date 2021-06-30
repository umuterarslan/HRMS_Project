package com.emin.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculaVitaeUpdateDto {

    private int id;
    private int jobSeekerId;
    private String coverLetter;
    private String pictureUrl;
    private int educationId;
    private LocalDate educationStartDate;

}
