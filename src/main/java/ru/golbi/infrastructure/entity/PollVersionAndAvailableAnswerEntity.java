package ru.golbi.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollVersionAndAvailableAnswerEntity.TABLE_NAME)
public class PollVersionAndAvailableAnswerEntity {

    public static final String TABLE_NAME = "pol_version_and_available_answer";
    public static final String POLL_VERSION_AND_AVAILABLE_ANSWER_ID_COLUMN_NAME = "poll_version_and_available_answer_id";
    public static final String POLL_VERSION_ID_COLUMN_NAME = "poll_version_id";
    public static final String AVAILABLE_ANSWER_ID_COLUMN_NAME = "available_answer_id";
    public static final String ENTITY_NAME = "PollVersionAndAvailableAnswerEntity";
    public static final String POLL_VERSION_AND_AVAILABLE_ANSWER_ID_FIELD_NAME = "pollVersionAndAvailableAnswerId";
    public static final String POL_VERSION_ID_FIELD_NAME = "pollVersionId";
    public static final String AVAILABLE_ANSWER_ID_FIELD_NAME = "availableAnswerId";

    @Id
    @Column(name = POLL_VERSION_AND_AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID pollVersionAndAvailableAnswerId;

    @Column(name = POLL_VERSION_ID_COLUMN_NAME)
    private UUID pollVersionId;

    @Column(name = AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID availableAnswerId;

}
