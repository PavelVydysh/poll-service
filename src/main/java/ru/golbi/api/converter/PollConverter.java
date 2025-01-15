package ru.golbi.api.converter;

import org.springframework.util.ObjectUtils;
import ru.golbi.api.dto.CreatePollRequestDto;
import ru.golbi.domain.model.Poll;

public class PollConverter {

    public static Poll toPoll(CreatePollRequestDto pollDto) {
        if (ObjectUtils.isEmpty(pollDto)) {
            return null;
        }

        Poll poll = new Poll();
        poll.setTitle(pollDto.getTitle());
        poll.setDescription(pollDto.getDescription());
        poll.setCreatorId(pollDto.getCreatorId());
        poll.setCreatorFullName(pollDto.getCreatorFullName());

        return poll;
    }

}
