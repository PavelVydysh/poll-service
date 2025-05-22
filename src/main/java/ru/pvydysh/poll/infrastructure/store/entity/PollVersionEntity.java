package ru.pvydysh.poll.infrastructure.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.pvydysh.poll.infrastructure.store.environment.PollVersionEnv;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollVersionEnv.TABLE_NAME)
public class PollVersionEntity {

    public static final String ENTITY_NAME = "PollVersionEntity";
    public static final String POLL_VERSION_ID_FIELD_NAME = "pollVersionId";
    public static final String POLL_ID_FIELD_NAME = "pollId";
    public static final String TITLE_FIELD_NAME = "title";
    public static final String CREATION_DATE_FIELD_NAME = "creationDate";
    public static final String POLL_ENTITY_FIELD_NAME = "poll";
    public static final String POLL_VERSION_AVAILABLE_ANSWERS_ENTITY_FIELD_NAME = "pollVersionAvailableAnswers";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = PollVersionEnv.POLL_VERSION_ID_COLUMN_NAME)
    private UUID pollVersionId;

    @Column(name = PollVersionEnv.POLL_ID_COLUMN_NAME)
    private UUID pollId;

    @Column(name = PollVersionEnv.TITLE_COLUMN_NAME)
    private String title;

    @Column(name = PollVersionEnv.CREATION_DATE_COLUMN_NAME)
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = PollVersionEnv.POLL_ID_COLUMN_NAME)
    private PollEntity poll;

}