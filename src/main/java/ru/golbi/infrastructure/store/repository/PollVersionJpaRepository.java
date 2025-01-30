package ru.golbi.infrastructure.store.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import ru.golbi.domain.model.PollVersion;
import ru.golbi.domain.repository.PollVersionRepository;
import ru.golbi.domain.wrapper.ResultWrapper;
import ru.golbi.infrastructure.store.converter.AvailableAnswerConverter;
import ru.golbi.infrastructure.store.converter.PollVersionConverter;
import ru.golbi.infrastructure.store.dao.AvailableAnswerDao;
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
    private final AvailableAnswerDao availableAnswerDao;
    private final PollVersionAndAvailableAnswerDao pollVersionAndAvailableAnswerDao;

    @Override
    @Transactional
    public ResultWrapper<Void> savePollVersion(UUID pollId, PollVersion pollVersion) {
        PollVersionEntity pollVersionEntity = PollVersionConverter.toPollVersionEntity(pollVersion);
        List<AvailableAnswerEntity> availableAnswerEntities = AvailableAnswerConverter.toListAvailableAnswerEntity(
                pollVersion.getAvailableAnswers()
        );

        UUID pollVersionEntityId = UUID.randomUUID();
        pollVersionEntity.setPollVersionId(pollVersionEntityId);
        pollVersionEntity.setPollId(pollId);
        pollVersionEntity.setNew(true);

        pollVersionDao.save(pollVersionEntity);

        List<PollVersionAndAvailableAnswerEntity> pollVersionAndAvailableAnswerEntities = new ArrayList<>();
        List<UUID> transmittedAvailableAnswerIds = new ArrayList<>();
        List<AvailableAnswerEntity> availableAnswerEntitiesToSave = new ArrayList<>();

        for (AvailableAnswerEntity availableAnswerEntity : availableAnswerEntities) {
            UUID availableAnswerId = availableAnswerEntity.getAvailableAnswerId();
            if (ObjectUtils.isEmpty(availableAnswerId)) {
                availableAnswerEntity.setAvailableAnswerId(
                        availableAnswerId = UUID.randomUUID()
                );
                availableAnswerEntity.setNew(true);
                availableAnswerEntitiesToSave.add(availableAnswerEntity);
            } else {
                transmittedAvailableAnswerIds.add(availableAnswerId);
            }
        }

        List<AvailableAnswerEntity> allAvailableAnswerEntities = availableAnswerDao.findAllByIds(
                transmittedAvailableAnswerIds
        );

        availableAnswerDao.saveAll(availableAnswerEntitiesToSave);

        allAvailableAnswerEntities.addAll(availableAnswerEntitiesToSave);

        for (AvailableAnswerEntity availableAnswerEntity : allAvailableAnswerEntities) {
            PollVersionAndAvailableAnswerEntity pollVersionAndAvailableAnswerEntity = new PollVersionAndAvailableAnswerEntity();
            pollVersionAndAvailableAnswerEntity.setPollVersionAndAvailableAnswerId(UUID.randomUUID());
            pollVersionAndAvailableAnswerEntity.setPollVersionId(pollVersionEntityId);
            pollVersionAndAvailableAnswerEntity.setAvailableAnswerId(availableAnswerEntity.getAvailableAnswerId());
            pollVersionAndAvailableAnswerEntity.setNew(true);

            pollVersionAndAvailableAnswerEntities.add(pollVersionAndAvailableAnswerEntity);
        }

        pollVersionAndAvailableAnswerDao.saveAll(pollVersionAndAvailableAnswerEntities);

        pollVersionEntity.setPollVersionsAndAvailableAnswers(pollVersionAndAvailableAnswerEntities);

        return new ResultWrapper<>();
    }

}
