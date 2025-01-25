package ru.golbi.infrastructure.store.repository;

import liquibase.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.Poll;
import ru.golbi.domain.repository.PollRepository;
import ru.golbi.domain.wrapper.ResultStatus;
import ru.golbi.domain.wrapper.ResultWrapper;
import ru.golbi.infrastructure.store.converter.AvailableAnswerConverter;
import ru.golbi.infrastructure.store.converter.PollConverter;
import ru.golbi.infrastructure.store.dao.AvailableAnswerDao;
import ru.golbi.infrastructure.store.dao.PollDao;
import ru.golbi.infrastructure.store.dao.PollVersionAndAvailableAnswerDao;
import ru.golbi.infrastructure.store.dao.PollVersionDao;
import ru.golbi.infrastructure.store.entity.AvailableAnswerEntity;
import ru.golbi.infrastructure.store.entity.PollEntity;
import ru.golbi.infrastructure.store.entity.PollVersionAndAvailableAnswerEntity;
import ru.golbi.infrastructure.store.entity.PollVersionEntity;

import java.util.ArrayList;
import java.util.List;
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
    public ResultWrapper<Void> create(Poll poll) {
        PollEntity pollEntity = PollConverter.toPollEntity(poll);
        PollVersionEntity pollVersionEntity = pollEntity.getVersions().get(0);
        List<AvailableAnswerEntity> availableAnswerEntities = AvailableAnswerConverter.toListAvailableAnswerEntity(
                poll.getLastVersion().getAvailableAnswers()
        );

        UUID pollEntityId = UUID.randomUUID();
        pollEntity.setPollId(pollEntityId);
        pollEntity.setNew(true);

        UUID pollVersionEntityId = UUID.randomUUID();
        pollVersionEntity.setPollVersionId(pollVersionEntityId);
        pollVersionEntity.setPollId(pollEntityId);
        pollVersionEntity.setNew(true);

        List<PollVersionAndAvailableAnswerEntity> pollVersionAndAvailableAnswerEntities = new ArrayList<>();
        for (AvailableAnswerEntity availableAnswerEntity : availableAnswerEntities) {
            UUID availableAnswerId = UUID.randomUUID();
            availableAnswerEntity.setAvailableAnswerId(availableAnswerId);
            availableAnswerEntity.setNew(true);

            PollVersionAndAvailableAnswerEntity pollVersionAndAvailableAnswerEntity = new PollVersionAndAvailableAnswerEntity();
            pollVersionAndAvailableAnswerEntity.setPollVersionAndAvailableAnswerId(UUID.randomUUID());
            pollVersionAndAvailableAnswerEntity.setPollVersionId(pollVersionEntityId);
            pollVersionAndAvailableAnswerEntity.setAvailableAnswerId(availableAnswerId);
            pollVersionAndAvailableAnswerEntity.setNew(true);

            pollVersionAndAvailableAnswerEntities.add(pollVersionAndAvailableAnswerEntity);
        }

        pollDao.save(pollEntity);
        pollVersionDao.save(pollVersionEntity);
        availableAnswerDao.saveAll(availableAnswerEntities);
        pollVersionAndAvailableAnswerDao.saveAll(pollVersionAndAvailableAnswerEntities);

        return new ResultWrapper<>();
    }

    @Override
    public ResultWrapper<Void> saveWithoutRelations(Poll poll) {
        PollEntity pollEntity = PollConverter.toPollEntity(poll);

        if(ObjectUtils.isEmpty(pollEntity.getPollId())) {
            pollEntity.setPollId(UUID.randomUUID());
            pollEntity.setNew(true);
        }

        pollDao.save(pollEntity);

        return new ResultWrapper<>();
    }

    @Override
    public ResultWrapper<Poll> findPollByIdWithoutVersions(UUID pollId) {
        Optional<PollEntity> pollEntityOptional = pollDao.findById(pollId);

        if(pollEntityOptional.isEmpty()) {
            return new ResultWrapper<>(ResultStatus.POLL_NOT_FOUND);
        }

        Poll poll = PollConverter.toPollWithoutVersions(pollEntityOptional.get());
        return new ResultWrapper<>(poll);
    }

}
