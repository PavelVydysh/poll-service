package ru.golbi.infrastructure.store.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.PollVersion;
import ru.golbi.infrastructure.store.entity.AvailableAnswerEntity;
import ru.golbi.infrastructure.store.entity.PollVersionAndAvailableAnswerEntity;
import ru.golbi.infrastructure.store.entity.PollVersionEntity;

import java.util.Collections;
import java.util.List;

public class PollVersionConverter {

    public static PollVersionEntity toPollVersionEntity(PollVersion pollVersion) {
        if (ObjectUtils.isEmpty(pollVersion)) {
            return null;
        }

        PollVersionEntity pollVersionEntity = new PollVersionEntity();
        pollVersionEntity.setPollVersionId(pollVersion.getPollVersionId());
        pollVersionEntity.setVersionNumber(pollVersion.getVersionNumber());
        pollVersionEntity.setCreationDate(pollVersion.getCreationDate());

        return pollVersionEntity;
    }

    public static List<PollVersionEntity> toListPollVersions(List<PollVersion> pollVersions) {
        if (CollectionUtils.isEmpty(pollVersions)) {
            return Collections.emptyList();
        }

        return pollVersions.stream()
                .map(PollVersionConverter::toPollVersionEntity)
                .toList();
    }

    public static PollVersion toPollVersion(PollVersionEntity pollVersionEntity) {
        if (ObjectUtils.isEmpty(pollVersionEntity)) {
            return null;
        }

        PollVersion pollVersion = new PollVersion();
        pollVersion.setPollVersionId(pollVersionEntity.getPollVersionId());
        pollVersion.setVersionNumber(pollVersionEntity.getVersionNumber());
        pollVersion.setCreationDate(pollVersionEntity.getCreationDate());

        List<AvailableAnswerEntity> availableAnswerEntities = pollVersionEntity.getPollVersionsAndAvailableAnswers()
                .stream()
                .map(PollVersionAndAvailableAnswerEntity::getAvailableAnswer)
                .toList();

        pollVersion.setAvailableAnswers(
                AvailableAnswerConverter.toListAvailableAnswer(availableAnswerEntities)
        );

        return pollVersion;
    }

    public static List<PollVersion> toListPollVersion(List<PollVersionEntity> pollVersionEntities) {
        if (CollectionUtils.isEmpty(pollVersionEntities)) {
            return Collections.emptyList();
        }

        return pollVersionEntities.stream()
                .map(PollVersionConverter::toPollVersion)
                .toList();
    }

}
