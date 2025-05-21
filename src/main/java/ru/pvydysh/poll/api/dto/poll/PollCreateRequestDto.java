package ru.pvydysh.poll.api.dto.poll;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PollCreateRequestDto {

    private String title;

    private List<AvailableAnswerRequestDto> availableAnswers;

    private String authorId;

    private String authorName;

}
