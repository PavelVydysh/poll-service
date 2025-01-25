package ru.golbi.infrastructure.store.dao;

import org.springframework.data.repository.CrudRepository;
import ru.golbi.infrastructure.store.entity.PollVersionEntity;

import java.util.UUID;

public interface PollVersionDao extends CrudRepository<PollVersionEntity, UUID> {
}