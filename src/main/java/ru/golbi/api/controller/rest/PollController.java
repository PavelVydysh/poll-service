package ru.golbi.api.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.golbi.api.converter.AvailableAnswerConverter;
import ru.golbi.api.converter.PollConverter;
import ru.golbi.api.dto.CreatePollRequestDto;
import ru.golbi.domain.model.AvailableAnswer;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.service.PollService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.application.private-prefix-path/poll}")
public class PollController {

    private final PollService pollService;

    @PostMapping
    public void createPoll(@RequestBody CreatePollRequestDto pollDto) {
        Poll poll = PollConverter.toPoll(pollDto);
        List<AvailableAnswer> availableAnswers = AvailableAnswerConverter.toListAvailableAnswer(pollDto.getAvailableAnswers());

        pollService.createPoll(poll, availableAnswers);
    }

}
