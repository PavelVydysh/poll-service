package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableAnswerRequestDto {

    private String title;

    private Integer position;

}