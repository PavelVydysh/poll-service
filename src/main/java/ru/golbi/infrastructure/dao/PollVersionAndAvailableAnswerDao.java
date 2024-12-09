package ru.golbi.infrastructure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.golbi.infrastructure.entity.PollVersionAndAvailableAnswerEntity;

import java.util.UUID;

@Repository
public interface PollVersionAndAvailableAnswerDao extends CrudRepository<PollVersionAndAvailableAnswerEntity, UUID> {
}
