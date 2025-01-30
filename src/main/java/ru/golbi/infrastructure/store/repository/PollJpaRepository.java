package ru.golbi.infrastructure.store.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.repository.PollRepository;
import ru.golbi.domain.wrapper.ResultStatus;
import ru.golbi.domain.wrapper.ResultWrapper;
import ru.golbi.infrastructure.store.converter.PollConverter;
import ru.golbi.infrastructure.store.dao.AvailableAnswerDao;
import ru.golbi.infrastructure.store.dao.PollDao;
import ru.golbi.infrastructure.store.dao.PollVersionAndAvailableAnswerDao;
import ru.golbi.infrastructure.store.dao.PollVersionDao;
import ru.golbi.infrastructure.store.entity.PollEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PollJpaRepository implements PollRepository {

    private final PollDao pollDao;

    private final PollVersionDao pollVersionDao;

    private final PollVersionAndAvailableAnswerDao pollVersionAndAvailableAnswerDao;

    private final AvailableAnswerDao availableAnswerDao;

    @Override
    @Transactional
    public ResultWrapper<Void> save(Poll poll) {
        PollEntity pollEntity = PollConverter.toPollEntity(poll);

        UUID pollId = pollEntity.getPollId();
        if (ObjectUtils.isEmpty(pollId)) {
            pollEntity.setPollId(UUID.randomUUID());
            pollEntity.setNew(true);
        }
        pollDao.save(pollEntity);

        return new ResultWrapper<>();
    }

    @Override
    @Transactional
    public ResultWrapper<Poll> findPollByIdWithoutVersions(UUID pollId) {
        Optional<PollEntity> pollEntityOptional = pollDao.findById(pollId);

        if (pollEntityOptional.isEmpty()) {
            return new ResultWrapper<>(ResultStatus.POLL_NOT_FOUND);
        }

        Poll poll = PollConverter.toPollWithoutVersions(pollEntityOptional.get());
        return new ResultWrapper<>(poll);
    }

}
