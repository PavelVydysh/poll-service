package ru.golbi.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.golbi.domain.exception.PollNotFoundException;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.model.UpdatePollInfo;
import ru.golbi.domain.repository.PollRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;

    public void createPoll(Poll poll) {
        pollRepository.save(poll);
    }

    public void editPoll(UUID pollId, Poll poll, UpdatePollInfo updateInfo) {
        Poll foundedPoll = pollRepository.findPollByIdWithoutVersions(pollId).orElseThrow(PollNotFoundException::new);
        foundedPoll.update(poll, updateInfo);

        pollRepository.save(foundedPoll);
    }

}
