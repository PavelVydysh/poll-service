package ru.golbi.infrastructure.store.dao;

import org.springframework.data.repository.CrudRepository;
import ru.golbi.infrastructure.store.entity.PollVersionAndAvailableAnswerEntity;

import java.util.UUID;

public interface PollVersionAndAvailableAnswerDao extends CrudRepository<PollVersionAndAvailableAnswerEntity, UUID> {
}
