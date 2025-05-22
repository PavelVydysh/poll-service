package ru.pvydysh.poll.infrastructure.store.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.pvydysh.poll.domain.model.poll.Poll;
import ru.pvydysh.poll.domain.repository.PollRepository;
import ru.pvydysh.poll.infrastructure.store.converter.PollConverter;
import ru.pvydysh.poll.infrastructure.store.dao.AvailableAnswerDao;
import ru.pvydysh.poll.infrastructure.store.dao.PollDao;
import ru.pvydysh.poll.infrastructure.store.dao.PollVersionDao;
import ru.pvydysh.poll.infrastructure.store.entity.PollEntity;

@Repository
@RequiredArgsConstructor
public class PollJpaRepository implements PollRepository {

    private final PollDao pollDao;
    private final PollVersionDao pollVersionDao;
    private final AvailableAnswerDao availableAnswerDao;

    @Override
    public void savePoll(Poll poll) {
        PollEntity pollEntity = PollConverter.toPollEntity(poll);

    }

}
