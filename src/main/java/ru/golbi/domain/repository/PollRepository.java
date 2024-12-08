package ru.golbi.domain.repository;

import ru.golbi.domain.model.Poll;

public interface PollRepository {

    void save(Poll poll);

}
