package ru.golbi.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = PollEntity.TABLE_NAME)
public class PollEntity {

    public static final String TABLE_NAME = "poll";
    public static final String POLL_ID_COLUMN_NAME = "poll_id";
    public static final String TITLE_COLUMN_NAME = "title";
    public static final String CREATION_DATE_COLUMN_NAME = "creation_date";
    public static final String ENTITY_NAME = "PollEntity";
    public static final String POLL_ID_FIELD_NAME = "pollId";
    public static final String TITLE_FIELD_NAME = "title";
    public static final String CREATION_DATE_FIELD_NAME = "creationDate";

    @Id
    @Column(name = POLL_ID_COLUMN_NAME)
    private UUID pollId;

    @Column(name = TITLE_COLUMN_NAME)
    private String title;

    @Column(name = CREATION_DATE_COLUMN_NAME)
    private LocalDate creationDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = PollEntity.POLL_ID_COLUMN_NAME, updatable = false, insertable = false)
    List<PollVersionEntity> pollVersionEntities;

}
