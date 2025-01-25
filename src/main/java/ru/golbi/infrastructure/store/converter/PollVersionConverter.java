package ru.golbi.infrastructure.store.converter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.PollVersion;
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

}
