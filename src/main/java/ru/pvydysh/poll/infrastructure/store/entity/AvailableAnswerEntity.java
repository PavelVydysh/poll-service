package ru.pvydysh.poll.infrastructure.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;
import ru.pvydysh.poll.infrastructure.store.environment.AvailableAnswerEnv;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = AvailableAnswerEnv.TABLE_NAME)
public class AvailableAnswerEntity {

    public static final String ENTITY_NAME = "AvailableAnswerEntity";
    public static final String AVAILABLE_ANSWER_ID_FIELD_NAME = "availableAnswerId";
    public static final String TITLE_FIELD_NAME = "title";
    public static final String POSITION_FIELD_NAME = "position";
    public static final String POLL_VERSION_AVAILABLE_ANSWERS_ENTITY_FIELD_NAME = "pollVersionAvailableAnswers";

    @Id
    @Column(name = AvailableAnswerEnv.AVAILABLE_ANSWER_ID_COLUMN_NAME)
    private UUID availableAnswerId;

    @Column(name = AvailableAnswerEnv.TITLE_COLUMN_NAME)
    private String title;

    @Column(name = AvailableAnswerEnv.POSITION_COLUMN_NAME)
    private Integer position;

    @ManyToMany(mappedBy = PollVersionEntity.AVAILABLE_ANSWERS_ENTITY_FIELD_NAME, fetch = FetchType.LAZY)
    private Set<PollVersionEntity> pollVersions;

    public Set<PollVersionEntity> getPollVersions() {
        if(CollectionUtils.isEmpty(pollVersions)) {
            pollVersions = new HashSet<>();
        }

        return pollVersions;
    }

}