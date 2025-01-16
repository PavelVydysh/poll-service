package ru.golbi.infrastructure.store.repository;

import org.springframework.stereotype.Repository;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.repository.PollRepository;
import ru.golbi.domain.wrapper.ResultWrapper;

@Repository
public class PollJpaRepository implements PollRepository {

    @Override
    public ResultWrapper<Void> create(Poll pol) {
        return null;
    }

}
