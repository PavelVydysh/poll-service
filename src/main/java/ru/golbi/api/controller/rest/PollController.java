package ru.golbi.api.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.golbi.api.converter.AvailableAnswerConverter;
import ru.golbi.api.converter.PollConverter;
import ru.golbi.api.converter.UpdatePollInfoConverter;
import ru.golbi.api.dto.CreatePollRequestDto;
import ru.golbi.api.dto.EditPollRequestDto;
import ru.golbi.domain.model.AvailableAnswer;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.model.UpdatePollInfo;
import ru.golbi.domain.service.PollService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.application.private-prefix-path}/poll")
public class PollController {

    private final PollService pollService;

    @PostMapping
    public void createPoll(@RequestBody CreatePollRequestDto pollDto) {
        Poll poll = PollConverter.toPoll(pollDto);
        List<AvailableAnswer> availableAnswers = AvailableAnswerConverter.toListAvailableAnswer(pollDto.getAvailableAnswers());

        pollService.createPoll(poll, availableAnswers);
    }

    @PatchMapping("/{pollId}")
    public void editPoll(@PathVariable UUID pollId, @RequestBody EditPollRequestDto pollDto) {
        Poll updatePoll = PollConverter.toPoll(pollDto);
        UpdatePollInfo updateInfo = UpdatePollInfoConverter.toUpdatePollInfo(pollDto.getUpdateInfo());

        pollService.editPoll(pollId, updatePoll, updateInfo);
    }

}
