package ru.golbi.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.golbi.domain.exception.PollNotFoundException;
import ru.golbi.domain.model.AvailableAnswer;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.repository.PollRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PollVersionService {

    private PollRepository pollRepository;

    public void createPollVersion(UUID pollId, List<AvailableAnswer> availableAnswers) {
        Poll poll = pollRepository.findPollByIdWithoutVersions(pollId)
                .orElseThrow(PollNotFoundException::new);

        poll.createNewVersion(availableAnswers);
    }

}
