package ru.pvydysh.poll.infrastructure.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pvydysh.poll.infrastructure.store.entity.PollEntity;

import java.util.UUID;

public interface PollDao extends JpaRepository<PollEntity, UUID> {

}
