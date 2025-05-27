package ru.pvydysh.poll.infrastructure.store.converter;

import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.domain.model.poll.Poll;
import ru.pvydysh.poll.infrastructure.store.entity.PollEntity;
import ru.pvydysh.poll.infrastructure.store.entity.PollVersionEntity;

import java.util.Set;

public class PollConverter {

    public static PollEntity toPollEntity(Poll poll) {
        if (ObjectUtils.isEmpty(poll)) {
            return null;
        }

        PollEntity pollEntity = new PollEntity();

        pollEntity.setPollId(poll.getPollId());
        pollEntity.setStatus(poll.getStatus());
        pollEntity.setAuthorId(poll.getAuthorId());
        pollEntity.setAuthorName(poll.getAuthorName());

        Set<PollVersionEntity> pollVersions = PollVersionConverter
                .toSetPollVersionEntities(
                        poll.getVersions()
                );
        pollVersions.forEach(version -> version.setPoll(pollEntity));
        pollEntity.setPollVersions(pollVersions);

        return pollEntity;
    }

}
