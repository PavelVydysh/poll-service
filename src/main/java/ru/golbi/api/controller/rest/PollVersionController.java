package ru.golbi.api.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.golbi.api.converter.AvailableAnswerConverter;
import ru.golbi.api.dto.version.CreatePollVersionRequestDto;
import ru.golbi.domain.model.AvailableAnswer;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.application.private-prefix-path}/version")
public class PollVersionController {

    @PostMapping
    public void createVersion(@RequestBody CreatePollVersionRequestDto pollVersionDto) {
        UUID pollId = pollVersionDto.getPollId();
        List<AvailableAnswer> availableAnswers = AvailableAnswerConverter.toListAvailableAnswer(pollVersionDto.getAvailableAnswers());
    }

}
