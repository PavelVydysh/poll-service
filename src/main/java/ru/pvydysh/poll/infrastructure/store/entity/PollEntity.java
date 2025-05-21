package ru.pvydysh.poll.infrastructure.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.pvydysh.poll.domain.model.enums.PollStatus;
import ru.pvydysh.poll.infrastructure.store.environment.PollEnv;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollEnv.TABLE_NAME)
public class PollEntity {

    public static final String ENTITY_NAME = "PollEntity";
    public static final String POLL_ID_FIELD_NAME = "pollId";
    public static final String AUTHOR_ID_FIELD_NAME = "authorId";
    public static final String AUTHOR_NAME_FIELD_NAME = "authorName";
    public static final String POLL_VERSIONS_ENTITY_FIELD_NAME = "pollVersions";

    @Id
    @Column(name = PollEnv.POLL_ID_COLUMN_NAME)
    private UUID pollId;

    @Column(name = PollEnv.AUTHOR_ID_COLUMN_NAME)
    private String authorId;

    @Column(name = PollEnv.AUTHOR_NAME_COLUMN_NAME)
    private String authorName;

    @Enumerated(EnumType.STRING)
    @Column(name = PollEnv.STATUS_COLUMN_NAME)
    private PollStatus status;

    @OneToMany(mappedBy = PollVersionEntity.POLL_ENTITY_FIELD_NAME, fetch = FetchType.LAZY)
    private Set<PollVersionEntity> pollVersions;

}
