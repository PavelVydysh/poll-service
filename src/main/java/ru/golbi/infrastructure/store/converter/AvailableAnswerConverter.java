package ru.golbi.infrastructure.store.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.AvailableAnswer;
import ru.golbi.infrastructure.store.entity.AvailableAnswerEntity;

import java.util.Collections;
import java.util.List;

public class AvailableAnswerConverter {

    public static AvailableAnswerEntity toAvailableAnswerEntity(AvailableAnswer availableAnswer) {
        if (ObjectUtils.isEmpty(availableAnswer)) {
            return null;
        }

        AvailableAnswerEntity availableAnswerEntity = new AvailableAnswerEntity();
        availableAnswerEntity.setAvailableAnswerId(availableAnswer.getAvailableAnswerId());
        availableAnswerEntity.setTitle(availableAnswer.getTitle());
        availableAnswerEntity.setPosition(availableAnswer.getPosition());

        return availableAnswerEntity;
    }

    public static List<AvailableAnswerEntity> toListAvailableAnswerEntity(List<AvailableAnswer> availableAnswers) {
        if (CollectionUtils.isEmpty(availableAnswers)) {
            return Collections.emptyList();
        }

        return availableAnswers.stream()
                .map(AvailableAnswerConverter::toAvailableAnswerEntity)
                .toList();

    }

}
