package ru.pvydysh.poll.infrastructure.store.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.domain.model.poll.PollVersion;
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
        pollVersionEntity.setAvailableAnswers(
                AvailableAnswerConverter.toCollectionAvailableAnswerEntity(
                        pollVersion.getAvailableAnswers()
                )
        );

        return pollVersionEntity;
    }

    public static Set<PollVersionEntity> toCollectionPollVersionEntities(Collection<PollVersion> pollVersions) {
        if (CollectionUtils.isEmpty(pollVersions)) {
            return Collections.emptySet();
        }

        return pollVersions.stream()
                .map(PollVersionConverter::toPollVersionEntity)
                .collect(Collectors.toSet());
    }

}
