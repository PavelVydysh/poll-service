package ru.pvydysh.poll.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pvydysh.poll.domain.model.poll.Poll;
import ru.pvydysh.poll.domain.repository.PollRepository;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;

    public void createPoll(Poll poll) {
        pollRepository.savePoll(poll);
    }

}
