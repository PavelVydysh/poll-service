package ru.pvydysh.poll.infrastructure.store.converter;

import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.domain.model.poll.Poll;
import ru.pvydysh.poll.infrastructure.store.entity.PollEntity;

public class PollConverter {

    public static PollEntity toPollEntity(Poll poll) {
        if (ObjectUtils.isEmpty(poll)) {
            return null;
        }

//        PollEntity pollEntity = new PollEntity();
//
//        pollEntity.setPollId(poll.getPollId());
//        pollEntity.setStatus(poll.getStatus());
//        pollEntity.setAuthorId(poll.getAuthorId());
//        pollEntity.setAuthorName(poll.getAuthorName());
//
//        char a = '\n';
        return null;
    }

}
