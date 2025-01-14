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

    private String title;

    private String description;

    private Integer versionNumber;

    private OffsetDateTime creationDate;

    List<AvailableAnswers> availableAnswers;

}
