package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PollRequestDto {

    private String title;

    private List<AvailableAnswerRequestDto> availableAnswers;

}
