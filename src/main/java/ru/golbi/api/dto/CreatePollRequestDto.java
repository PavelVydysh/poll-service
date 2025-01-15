package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePollRequestDto {

    private String creatorId;

    private String creatorFullName;

    private String title;

    private String description;

    private List<CreateAvailableAnswerRequestDto> availableAnswers;

}
