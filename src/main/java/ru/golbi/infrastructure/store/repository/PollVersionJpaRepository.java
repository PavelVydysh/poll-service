package ru.golbi.infrastructure.store.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.golbi.domain.model.PollVersion;
import ru.golbi.domain.repository.PollVersionRepository;
import ru.golbi.domain.wrapper.ResultWrapper;
import ru.golbi.infrastructure.store.converter.AvailableAnswerConverter;
import ru.golbi.infrastructure.store.converter.PollVersionConverter;
import ru.golbi.infrastructure.store.dao.PollVersionAndAvailableAnswerDao;
import ru.golbi.infrastructure.store.dao.PollVersionDao;
import ru.golbi.infrastructure.store.entity.AvailableAnswerEntity;
import ru.golbi.infrastructure.store.entity.PollVersionAndAvailableAnswerEntity;
import ru.golbi.infrastructure.store.entity.PollVersionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PollVersionJpaRepository implements PollVersionRepository {

    private final PollVersionDao pollVersionDao;
    private final PollVersionAndAvailableAnswerDao pollVersionAndAvailableAnswerDao;

    @Override
    public ResultWrapper<Void> savePollVersion(UUID pollId, PollVersion pollVersion) {
        PollVersionEntity pollVersionEntity = PollVersionConverter.toPollVersionEntity(pollVersion);
        List<AvailableAnswerEntity> availableAnswerEntities = AvailableAnswerConverter.toListAvailableAnswerEntity(
                pollVersion.getAvailableAnswers()
        );

        UUID pollVersionEntityId = UUID.randomUUID();
        pollVersionEntity.setPollVersionId(pollVersionEntityId);
        pollVersionEntity.setPollId(pollId);
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

        pollVersionDao.save(pollVersionEntity);
//        availableAnswerDao.saveAll(availableAnswerEntities);
        pollVersionAndAvailableAnswerDao.saveAll(pollVersionAndAvailableAnswerEntities);

        pollVersionEntity.setPollVersionsAndAvailableAnswers(pollVersionAndAvailableAnswerEntities);

        return new ResultWrapper<>();
    }

}
