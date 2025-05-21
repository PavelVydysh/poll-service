package ru.pvydysh.poll.api.converter.poll;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import ru.pvydysh.poll.api.dto.poll.AvailableAnswerRequestDto;
import ru.pvydysh.poll.domain.model.poll.Poll;
import ru.pvydysh.poll.domain.model.poll.PollVersion;

import java.util.Collections;
import java.util.List;

public class PollVersionConverter {

    public static PollVersion toPollVersion(String title, List<AvailableAnswerRequestDto> availableAnswerRequestDtos) {
        if(StringUtils.hasText(title) && CollectionUtils.isEmpty(availableAnswerRequestDtos)) {
            return null;
        }

        PollVersion pollVersion = new PollVersion();
        pollVersion.setTitle(title);
        pollVersion.setAvailableAnswers(
                AvailableAnswerConverter.toListAvailableAnswer(
                        availableAnswerRequestDtos
                )
        );

        return pollVersion;
    }

}
