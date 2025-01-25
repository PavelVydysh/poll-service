package ru.golbi.infrastructure.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;
import ru.golbi.infrastructure.environment.PollVersionAndAvailableAnswerEnvironment;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollVersionAndAvailableAnswerEnvironment.TABLE_NAME)
public class PollVersionAndAvailableAnswerEntity implements Persistable<UUID> {

    public static final String ENTITY_NAME = "PollVersionAndAvailableAnswerEntity";

    public static final String POLL_VERSION_AND_AVAILABLE_ANSWER_ID_FIELD_NAME = "pollVersionAndAvailableAnswerId";

    public static final String POLL_VERSION_ID_FIELD_NAME = "pollVersionId";

    public static final String AVAILABLE_ANSWER_ID_FIELD_NAME = "availableAnswerId";

    public static final String POLL_VERSION_FIELD_NAME = "pollVersion";

    public static final String AVAILABLE_ANSWER_FIELD_NAME = "availableAnswer";

    @Id
    @Column(name = PollVersionAndAvailableAnswerEnvironment.POLL_VERSION_AND_AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID pollVersionAndAvailableAnswerId;

    @Column(name = PollVersionAndAvailableAnswerEnvironment.POLL_VERSION_ID_COLUMN_NAME)
    private UUID pollVersionId;

    @Column(name = PollVersionAndAvailableAnswerEnvironment.AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID availableAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = PollVersionAndAvailableAnswerEnvironment.POLL_VERSION_ID_COLUMN_NAME, insertable = false, updatable = false)
    private PollVersionEntity pollVersion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = PollVersionAndAvailableAnswerEnvironment.AVAILABLE_ANSWER_ID_COLUMN_NAME, insertable = false, updatable = false)
    private AvailableAnswerEntity availableAnswer;

    @Transient
    private boolean isNew;

    @Override
    public UUID getId() {
        return pollVersionAndAvailableAnswerId;
    }

}
