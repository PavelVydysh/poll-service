package ru.pvydysh.poll.domain.repository;

import ru.pvydysh.poll.domain.model.poll.Poll;

public interface PollRepository {

    void savePoll(Poll poll);

}
