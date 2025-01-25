package ru.golbi.infrastructure.store.dao;

import org.springframework.data.repository.CrudRepository;
import ru.golbi.infrastructure.store.entity.PollEntity;

import java.util.UUID;

public interface PollDao extends CrudRepository<PollEntity, UUID> {
}
