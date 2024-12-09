package ru.golbi.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.repository.PollRepository;
import ru.golbi.infrastructure.dao.AvailableAnswerDao;
import ru.golbi.infrastructure.dao.PollDao;
import ru.golbi.infrastructure.dao.PollVersionAndAvailableAnswerDao;
import ru.golbi.infrastructure.dao.PollVersionDao;

@Repository
@RequiredArgsConstructor
public class PollJpaRepository implements PollRepository {

    private final PollDao pollDao;
    private final PollVersionDao pollVersionDao;
    private final PollVersionAndAvailableAnswerDao pollVersionAndAvailableAnswerDao;
    private final AvailableAnswerDao availableAnswerDao;

    @Override
    public void save(Poll poll) {



    }

}
