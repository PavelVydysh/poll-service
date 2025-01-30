package ru.golbi.api.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.golbi.api.dto.CreateAvailableAnswerRequestDto;
import ru.golbi.domain.model.AvailableAnswer;

import java.util.Collections;
import java.util.List;

public class AvailableAnswerConverter {

    public static AvailableAnswer toAvailableAnswer(CreateAvailableAnswerRequestDto availableAnswerDto) {
        if (ObjectUtils.isEmpty(availableAnswerDto)) {
            return null;
        }

        AvailableAnswer availableAnswer = new AvailableAnswer();
        availableAnswer.setAvailableAnswerId(availableAnswerDto.getAvailableAnswerId());
        availableAnswer.setTitle(availableAnswerDto.getTitle());
        availableAnswer.setPosition(availableAnswerDto.getPosition());

        return availableAnswer;
    }

    public static List<AvailableAnswer> toListAvailableAnswer(List<CreateAvailableAnswerRequestDto> availableAnswerDtos) {
        if (CollectionUtils.isEmpty(availableAnswerDtos)) {
            return Collections.emptyList();
        }

        return availableAnswerDtos.stream()
                .map(AvailableAnswerConverter::toAvailableAnswer)
                .toList();

    }

}
