package ru.golbi.api.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.golbi.api.dto.CreatePollRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.application.private-prefix-path/poll}")
public class PollController {

    @PostMapping
    public void createPoll(@RequestBody CreatePollRequestDto pollDto) {

    }

}
