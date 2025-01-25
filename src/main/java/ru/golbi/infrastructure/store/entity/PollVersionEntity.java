package ru.golbi.infrastructure.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;
import ru.golbi.infrastructure.environment.PollVersionEnvironment;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollVersionEnvironment.TABLE_NAME)
public class PollVersionEntity implements Persistable<UUID> {

    public static final String ENTITY_NAME = "PollVersionEntity";

    public static final String POLL_VERSION_ID_FIELD_NAME = "pollVersionId";

    public static final String POLL_ID_FIELD_NAME = "pollId";

    public static final String VERSION_NUMBER_FIELD_NAME = "versionNumber";

    public static final String CREATION_DATE_FIELD_NAME = "creationDate";

    public static final String POLL_FILED_NAME = "poll";

    @Id
    @Column(name = PollVersionEnvironment.POLL_VERSION_ID_COLUMN_NAME)
    private UUID pollVersionId;

    @Column(name = PollVersionEnvironment.POLL_ID_COLUMN_NAME)
    private UUID pollId;

    @Column(name = PollVersionEnvironment.VERSION_NUMBER_COLUMN_NAME)
    private Integer versionNumber;

    @Column(name = PollVersionEnvironment.CREATION_DATE_COLUMN_NAME)
    private OffsetDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = PollVersionEnvironment.POLL_ID_COLUMN_NAME, insertable = false, updatable = false)
    private PollEntity poll;

    @OneToMany(mappedBy = PollVersionAndAvailableAnswerEntity.POLL_VERSION_FIELD_NAME,fetch = FetchType.LAZY)
    private List<PollVersionAndAvailableAnswerEntity> pollVersionsAndAvailableAnswers;

    @Transient
    private boolean isNew;

    @Override
    public UUID getId() {
        return pollVersionId;
    }

}
