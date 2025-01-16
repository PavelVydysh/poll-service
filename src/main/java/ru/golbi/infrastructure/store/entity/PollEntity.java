package ru.golbi.infrastructure.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import ru.golbi.infrastructure.environment.PollEnvironment;

import java.util.UUID;

@Entity
@Table(name = PollEnvironment.TABLE_NAME)
public class PollEntity {

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

    //добавить список версий

}
