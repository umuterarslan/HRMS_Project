package com.emin.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculaVitaeCoverLetterUpdateDto {

    private int curriculaVitaeId;
    private String coverLetter;

}
