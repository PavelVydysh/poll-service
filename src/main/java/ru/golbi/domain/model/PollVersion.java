package ru.golbi.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PollVersion {

    private UUID pollVersionId;

    private Integer versionNumber;

    private OffsetDateTime creationDate;

    private List<AvailableAnswer> availableAnswers;

    public PollVersion() {
        this.creationDate = OffsetDateTime.now();
    }

}
