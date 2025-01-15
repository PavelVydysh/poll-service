package ru.golbi.domain.repository;

import ru.golbi.domain.model.Poll;
import ru.golbi.domain.wrapper.ResultWrapper;

public interface PollRepository {

    ResultWrapper<Void> create(Poll pol);

}
