package ru.golbi.infrastructure.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;
import ru.golbi.infrastructure.environment.AvailableAnswerEnvironment;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = AvailableAnswerEnvironment.TABLE_NAME)
public class AvailableAnswerEntity implements Persistable<UUID> {

    public static final String ENTITY_NAME = "AvailableAnswerEntity";

    public static final String AVAILABLE_ANSWER_ID_FIELD_NAME = "availableAnswerId";

    public static final String TITLE_FIELD_NAME = "title";

    public static final String POSITION_FIELD_NAME = "position";

    @Id
    @Column(name = AvailableAnswerEnvironment.AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID availableAnswerId;

    @Column(name = AvailableAnswerEnvironment.TITLE_COLUMN_NAME)
    private String title;

    @Column(name = AvailableAnswerEnvironment.POSITION_COLUMN_NAME)
    private Integer position;

    @OneToMany(mappedBy = PollVersionAndAvailableAnswerEntity.AVAILABLE_ANSWER_FIELD_NAME, fetch = FetchType.LAZY)
    private List<PollVersionAndAvailableAnswerEntity> pollVersionsAndAvailableAnswers;

    @Transient
    private boolean isNew;

    @Override
    public UUID getId() {
        return availableAnswerId;
    }

}
