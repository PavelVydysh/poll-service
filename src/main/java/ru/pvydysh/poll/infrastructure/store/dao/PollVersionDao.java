package ru.pvydysh.poll.infrastructure.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pvydysh.poll.infrastructure.store.entity.PollVersionEntity;

import java.util.UUID;

public interface PollVersionDao extends JpaRepository<PollVersionEntity, UUID> {

}
