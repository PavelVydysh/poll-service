package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateAvailableAnswerRequestDto {

    private UUID availableAnswerId;

    private String title;

    private Integer position;

}
