package ru.golbi.api.converter;

import org.springframework.util.ObjectUtils;
import ru.golbi.api.dto.CreatePollRequestDto;
import ru.golbi.api.dto.EditPollRequestDto;
import ru.golbi.domain.model.Poll;

public class PollConverter {

    public static Poll toPoll(CreatePollRequestDto pollDto) {
        if (ObjectUtils.isEmpty(pollDto)) {
            return null;
        }

        Poll poll = new Poll();
        poll.setTitle(pollDto.getTitle());
        poll.setDescription(pollDto.getDescription());
        poll.setCreatorUserId(pollDto.getCreatorUserId());
        poll.setCreatorFullName(pollDto.getCreatorFullName());

        return poll;
    }

    public static Poll toPoll(EditPollRequestDto pollDto) {
        if (ObjectUtils.isEmpty(pollDto)) {
            return null;
        }

        Poll poll = new Poll();
        poll.setTitle(pollDto.getTitle());
        poll.setDescription(pollDto.getDescription());

        return poll;
    }

}
