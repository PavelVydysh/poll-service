package ru.golbi.domain.repository;

import ru.golbi.domain.model.PollVersion;
import ru.golbi.domain.wrapper.ResultWrapper;

import java.util.UUID;

public interface PollVersionRepository {

    ResultWrapper<Void> savePollVersion(UUID pollId, PollVersion pollVersion);

}
