package ru.golbi.infrastructure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.golbi.infrastructure.entity.PollVersionEntity;

import java.util.UUID;

@Repository
public interface PollVersionDao extends CrudRepository<PollVersionEntity, UUID> {
}
