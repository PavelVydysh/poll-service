package ru.pvydysh.poll.api.converter.poll;

import org.springframework.util.ObjectUtils;
import ru.pvydysh.poll.api.dto.poll.PollCreateRequestDto;
import ru.pvydysh.poll.domain.model.poll.Poll;

import java.util.List;

public class PollConverter {

    public static Poll toPoll(PollCreateRequestDto pollDto) {
        if (ObjectUtils.isEmpty(pollDto)) {
            return null;
        }

        Poll poll = new Poll();
        poll.setVersions(
                List.of(
                        PollVersionConverter.toPollVersion(
                                pollDto.getTitle(),
                                pollDto.getAvailableAnswers()
                        )
                )
        );
        poll.setAuthorId(pollDto.getAuthorId());
        poll.setAuthorName(pollDto.getAuthorName());

        return poll;
    }

}
