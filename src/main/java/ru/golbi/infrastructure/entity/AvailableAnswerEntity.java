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
@Table(name = AvailableAnswerEntity.TABLE_NAME)
public class AvailableAnswerEntity {

    public static final String TABLE_NAME = "available_answer";
    public static final String AVAILABLE_ANSWER_ID_COLUMN_NAME = "available_answer_id";
    public static final String TITLE_COLUMN_NAME = "title";
    public static final String POSITION_COLUMN_NAME = "position";
    public static final String ENTITY_NAME = "AvailableAnswerEntity";
    public static final String AVAILABLE_ANSWER_ID_ENTITY_FIELD = "availableAnswerId";
    public static final String TITLE_ENTITY_FIELD = "title";
    public static final String POSITION_ENTITY_FIELD = "position";

    @Id
    @Column(name = AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID availableAnswerId;

    @Column(name = TITLE_COLUMN_NAME)
    private String title;

    @Column(name = POSITION_COLUMN_NAME)
    private Integer position;

}
