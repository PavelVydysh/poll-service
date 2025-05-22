package ru.pvydysh.poll.infrastructure.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pvydysh.poll.infrastructure.store.entity.AvailableAnswerEntity;

import java.util.UUID;

public interface AvailableAnswerDao extends JpaRepository<AvailableAnswerEntity, UUID> {

}
