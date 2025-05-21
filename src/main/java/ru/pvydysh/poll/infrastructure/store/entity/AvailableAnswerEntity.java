package ru.pvydysh.poll.infrastructure.store.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.Set;
import java.util.UUID;

public class AvailableAnswerEntity {

    private UUID availableAnswerId;

    private String title;

    private Integer position;

    @OneToMany(mappedBy = "availableAnswer", fetch = FetchType.LAZY)
    private Set<PollVersionAvailableAnswerEntity> pollVersionAvailableAnswers;

}