package ru.pvydysh.poll.api.converter.poll;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.api.dto.poll.AvailableAnswerRequestDto;
import ru.pvydysh.poll.domain.model.poll.AvailableAnswer;

import java.util.Collections;
import java.util.List;

public class AvailableAnswerConverter {

    public static AvailableAnswer toAvailableAnswer(AvailableAnswerRequestDto availableAnswerDto) {
        if(ObjectUtils.isEmpty(availableAnswerDto)) {
            return null;
        }

        AvailableAnswer availableAnswer = new AvailableAnswer();
        availableAnswer.setTitle(availableAnswerDto.getTitle());
        availableAnswer.setPosition(availableAnswerDto.getPosition());

        return availableAnswer;
    }

    public static List<AvailableAnswer> toListAvailableAnswer(List<AvailableAnswerRequestDto> availableAnswerDtos) {
        if(CollectionUtils.isEmpty(availableAnswerDtos)) {
            return Collections.emptyList();
        }

        return availableAnswerDtos.stream()
                .map(AvailableAnswerConverter::toAvailableAnswer)
                .toList();
    }

}
