package ru.pvydysh.poll.infrastructure.store.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class PollVersionAvailableAnswerEntity {

    public static final String ENTITY_NAME = "PollVersionAvailableAnswerEntity";


    private UUID pollVersionAvailableAnswerId;

    private UUID pollVersionId;

    private UUID availableAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_version_id", updatable = false, insertable = false)
    private PollVersionEntity pollVersion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_answer_id", updatable = false, insertable = false)
    private AvailableAnswerEntity availableAnswer;

}
