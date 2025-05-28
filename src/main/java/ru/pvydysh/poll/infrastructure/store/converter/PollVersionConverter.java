package ru.pvydysh.poll.infrastructure.store.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.domain.model.poll.PollVersion;
import ru.pvydysh.poll.infrastructure.store.entity.AvailableAnswerEntity;
import ru.pvydysh.poll.infrastructure.store.entity.PollVersionEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class PollVersionConverter {

    public static PollVersionEntity toPollVersionEntity(PollVersion pollVersion) {
        if (ObjectUtils.isEmpty(pollVersion)) {
            return null;
        }

        PollVersionEntity pollVersionEntity = new PollVersionEntity();
        pollVersionEntity.setPollVersionId(pollVersion.getPollVersionId());
        pollVersionEntity.setTitle(pollVersion.getTitle());
        pollVersionEntity.setCreationDate(pollVersion.getCreationDate());

        Set<AvailableAnswerEntity> availableAnswers = AvailableAnswerConverter
                .toSetAvailableAnswerEntity(
                        pollVersion.getAvailableAnswers()
                );
        availableAnswers.forEach(availableAnswer -> availableAnswer
                .getPollVersions()
                .add(pollVersionEntity)
        );
        pollVersionEntity.setAvailableAnswers(availableAnswers);

        return pollVersionEntity;
    }

    public static Set<PollVersionEntity> toSetPollVersionEntities(Collection<PollVersion> pollVersions) {
        if (CollectionUtils.isEmpty(pollVersions)) {
            return Collections.emptySet();
        }

        return pollVersions.stream()
                .map(PollVersionConverter::toPollVersionEntity)
                .collect(Collectors.toSet());
    }

}
