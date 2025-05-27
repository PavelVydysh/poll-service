package ru.pvydysh.poll.infrastructure.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.pvydysh.poll.domain.model.poll.AvailableAnswer;
import ru.pvydysh.poll.infrastructure.store.environment.PollVersionAvailableAnswerEnv;
import ru.pvydysh.poll.infrastructure.store.environment.PollVersionEnv;

import java.time.LocalDate;
import java.util.Set;
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
    public static final String AVAILABLE_ANSWERS_ENTITY_FIELD_NAME = "availableAnswers";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = PollVersionEnv.POLL_VERSION_ID_COLUMN_NAME)
    private UUID pollVersionId;

    @Column(name = PollVersionEnv.TITLE_COLUMN_NAME)
    private String title;

    @Column(name = PollVersionEnv.CREATION_DATE_COLUMN_NAME)
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = PollVersionEnv.POLL_ID_COLUMN_NAME)
    private PollEntity poll;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = PollVersionAvailableAnswerEnv.TABLE_NAME,
            joinColumns = @JoinColumn(name = PollVersionAvailableAnswerEnv.POLL_VERSION_ID_COLUMN_NAME),
            inverseJoinColumns = @JoinColumn(name = PollVersionAvailableAnswerEnv.AVAILABLE_ANSWER_ID_COLUMN_ID)
    )
    private Set<AvailableAnswerEntity> availableAnswers;

}