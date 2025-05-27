package ru.pvydysh.poll.infrastructure.store.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.domain.model.poll.AvailableAnswer;
import ru.pvydysh.poll.infrastructure.store.entity.AvailableAnswerEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static Set<AvailableAnswerEntity> toSetAvailableAnswerEntity(Collection<AvailableAnswer> availableAnswers) {
        if (CollectionUtils.isEmpty(availableAnswers)) {
            return Collections.emptySet();
        }

        return availableAnswers.stream()
                .map(AvailableAnswerConverter::toAvailableAnswerEntity)
                .collect(Collectors.toSet());
    }

}
