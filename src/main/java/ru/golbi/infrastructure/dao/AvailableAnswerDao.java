package ru.golbi.infrastructure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.golbi.infrastructure.entity.AvailableAnswerEntity;

import java.util.UUID;

@Repository
public interface AvailableAnswerDao extends CrudRepository<AvailableAnswerEntity, UUID> {
}
