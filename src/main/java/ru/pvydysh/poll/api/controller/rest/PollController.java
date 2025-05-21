package ru.pvydysh.poll.api.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pvydysh.poll.api.converter.poll.PollConverter;
import ru.pvydysh.poll.api.dto.poll.PollCreateRequestDto;
import ru.pvydysh.poll.domain.model.poll.Poll;

@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.application.private-prefix-path}/poll")
@Tag(name = "PollController", description = "API для работы с опросами")
public class PollController {

    @PostMapping
    @Operation(summary = "Создание опроса")
    public void createPoll(@RequestBody PollCreateRequestDto pollDto) {
        Poll poll = PollConverter.toPoll(pollDto);

    }

}
