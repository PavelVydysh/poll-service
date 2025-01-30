package ru.golbi.api.dto.version;

import lombok.Getter;
import lombok.Setter;
import ru.golbi.api.dto.CreateAvailableAnswerRequestDto;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreatePollVersionRequestDto {

    private UUID pollId;

    private List<CreateAvailableAnswerRequestDto> availableAnswers;

}
