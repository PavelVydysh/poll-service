package ru.golbi.infrastructure.entity;

import jakarta.persistence.Entity;
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

    private UUID pollVersionAndAvailableAnswerId;

    private UUID pollVersionId;

    private UUID availableAnswerId;



}
