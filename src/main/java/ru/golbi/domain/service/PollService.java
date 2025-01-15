package ru.golbi.domain.service;

import org.springframework.stereotype.Service;
import ru.golbi.domain.model.AvailableAnswer;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.repository.PollRepository;

import java.util.List;

@Service
public class PollService {

    private PollRepository pollRepository;

    public void createPoll(Poll poll, List<AvailableAnswer> availableAnswers) {
        poll.createNewVersion(availableAnswers);
    }


}
