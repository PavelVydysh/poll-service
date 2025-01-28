package ru.golbi.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.exception.PollNotFoundException;
import ru.golbi.domain.model.AvailableAnswer;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.model.PollVersion;
import ru.golbi.domain.repository.PollRepository;
import ru.golbi.domain.repository.PollVersionRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PollVersionService {

    private PollRepository pollRepository;
    private PollVersionRepository pollVersionRepository;

    private static final Integer INCREMENT_VERSION_VALUE = 1;
    private static final Integer START_VERSION_NUMBER = 1;

    public void createPollVersion(UUID pollId, List<AvailableAnswer> availableAnswers) {
        Poll poll = pollRepository.findPollByIdWithoutVersions(pollId)
                .orElseThrow(PollNotFoundException::new);

        PollVersion lastVersion = poll.getLastVersion();

        PollVersion pollVersion = new PollVersion();

        if(ObjectUtils.isEmpty(lastVersion)) {
            pollVersion.setVersionNumber(lastVersion.getVersionNumber() + INCREMENT_VERSION_VALUE);
        } else {
            pollVersion.setVersionNumber(START_VERSION_NUMBER);
        }

        pollVersionRepository.savePollVersion(pollId, pollVersion);
    }

}
