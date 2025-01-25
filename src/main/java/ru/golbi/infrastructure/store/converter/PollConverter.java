package ru.golbi.infrastructure.store.converter;

import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.Poll;
import ru.golbi.infrastructure.store.entity.PollEntity;

public class PollConverter {

    public static PollEntity toPollEntity(Poll poll) {
        if (ObjectUtils.isEmpty(poll)) {
            return null;
        }

        PollEntity pollEntity = new PollEntity();
        pollEntity.setPollId(poll.getPollId());
        pollEntity.setTitle(poll.getTitle());
        pollEntity.setDescription(poll.getDescription());
        pollEntity.setCreatorUserId(poll.getCreatorUserId());
        pollEntity.setCreatorFullName(poll.getCreatorFullName());
        pollEntity.setVersions(
            PollVersionConverter.toListPollVersions(poll.getVersions())
        );

        return pollEntity;
    }

}
