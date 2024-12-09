package ru.golbi.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollVersionEntity.TABLE_NAME)
public class PollVersionEntity {

    public static final String TABLE_NAME = "poll_version";
    public static final String POLL_VERSION_ID_COLUMN_NAME = "poll_version_id";
    public static final String POLL_ID_COLUMN_NAME = "poll_id";
    public static final String VERSION_COLUMN_NAME = "version";
    public static final String CREATION_DATE_COLUMN_NAME = "creation_date";
    public static final String ENTITY_NAME = "PollVersionEntity";
    public static final String POLL_VERSION_ID_FIELD_NAME = "pollVersionId";
    public static final String POLL_ID_FIELD_NAME = "pollId";
    public static final String VERSION_FILED_NAME = "version";
    public static final String CREATION_DATE_FIELD_NAME = "creationDate";

    @Id
    @Column(name = POLL_VERSION_ID_COLUMN_NAME)
    private UUID pollVersionId;

    @Column(name = POLL_ID_COLUMN_NAME)
    private UUID pollId;

    @Column(name = VERSION_COLUMN_NAME)
    private Integer version;

    @Column(name = CREATION_DATE_COLUMN_NAME)
    private LocalDate creationDate;

    @ManyToMany
    @JoinTable(
            name = PollVersionAndAvailableAnswerEntity.TABLE_NAME,
            joinColumns = @JoinColumn(name = PollVersionAndAvailableAnswerEntity.POLL_VERSION_ID_COLUMN_NAME,
                    updatable = false, insertable = false),
            inverseJoinColumns = @JoinColumn(name = PollVersionAndAvailableAnswerEntity.AVAILABLE_ANSWER_ID_COLUMN_NAME,
                    updatable = false, insertable = false)
    )
    private List<AvailableAnswerEntity> availableAnswerEntities;

}
