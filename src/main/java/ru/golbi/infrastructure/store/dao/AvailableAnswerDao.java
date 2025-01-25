package ru.golbi.infrastructure.store.dao;

import org.springframework.data.repository.CrudRepository;
import ru.golbi.infrastructure.store.entity.AvailableAnswerEntity;

import java.util.UUID;

public interface AvailableAnswerDao extends CrudRepository<AvailableAnswerEntity, UUID> {
}
