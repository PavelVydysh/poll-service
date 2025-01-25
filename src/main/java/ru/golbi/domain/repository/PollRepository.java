package ru.golbi.domain.repository;

import ru.golbi.domain.model.Poll;
import ru.golbi.domain.wrapper.ResultWrapper;

import java.util.UUID;

public interface PollRepository {

    ResultWrapper<Void> create(Poll pol);

    ResultWrapper<Void> saveWithoutRelations(Poll poll);

    ResultWrapper<Poll> findPollByIdWithoutVersions(UUID pollId);

}
