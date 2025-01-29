package ru.golbi.infrastructure.store.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.golbi.infrastructure.store.entity.AvailableAnswerEntity;

import java.util.List;
import java.util.UUID;

public interface AvailableAnswerDao extends CrudRepository<AvailableAnswerEntity, UUID> {

    @Query(
            "SELECT av FROM " + AvailableAnswerEntity.ENTITY_NAME + " av " +
            "WHERE av." + AvailableAnswerEntity.AVAILABLE_ANSWER_ID_FIELD_NAME + " IN :ids"
    )
    List<AvailableAnswerEntity> findAllByIds(List<UUID> ids);



}
