package ru.golbi.domain.repository;

import ru.golbi.domain.model.Poll;
import ru.golbi.domain.wrapper.ResultWrapper;

import java.util.UUID;

public interface PollRepository {

    ResultWrapper<Void> save(Poll pol);

    ResultWrapper<Poll> findPollByIdWithoutVersions(UUID pollId);

}
