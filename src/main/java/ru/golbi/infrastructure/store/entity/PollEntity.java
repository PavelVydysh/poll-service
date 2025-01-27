package ru.golbi.infrastructure.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.data.domain.Persistable;
import ru.golbi.infrastructure.environment.PollEnvironment;
import ru.golbi.infrastructure.environment.PollVersionEnvironment;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollEnvironment.TABLE_NAME)
public class PollEntity implements Persistable<UUID> {

    public static final String ENTITY_NAME = "PollEntity";

    public static final String POLL_ID_FILED_NAME = "pollId";

    public static final String TITLE_FIELD_NAME = "title";

    public static final String DESCRIPTION_FIELD_NAME = "description";

    public static final String CREATOR_USER_ID_FIELD_NAME = "creatorUserId";

    public static final String CREATOR_FULL_NAME_FIELD_NAME = "creatorFullName";

    @Id
    @Column(name = PollEnvironment.POLL_ID_COLUMN_NAME)
    private UUID pollId;

    @Column(name = PollEnvironment.TITLE_COLUMN_NAME)
    private String title;

    @Column(name = PollEnvironment.DESCRIPTION_COLUMN_NAME)
    private String description;

    @Column(name = PollEnvironment.CREATOR_USER_ID_COLUMN_NAME)
    private String creatorUserId;

    @Column(name = PollEnvironment.CREATOR_FULL_NAME_COLUMN_NAME)
    private String creatorFullName;

    @Formula(
            value = "SELECT MAX(pv." + PollVersionEnvironment.VERSION_NUMBER_COLUMN_NAME + ") " +
                    "FROM " + PollVersionEnvironment.TABLE_NAME + " pv " +
                    "WHERE pv." + PollVersionEnvironment.POLL_ID_COLUMN_NAME + " = " + PollVersionEnvironment.POLL_ID_COLUMN_NAME
    )
    private Integer lastVersionNumber;

    @OneToMany(mappedBy = PollVersionEntity.POLL_FILED_NAME, fetch = FetchType.LAZY)
    private List<PollVersionEntity> versions;

    @Transient
    private boolean isNew;

    @Override
    public UUID getId() {
        return pollId;
    }
}
