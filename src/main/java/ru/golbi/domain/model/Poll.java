package ru.golbi.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Poll {

    private UUID pollId;

    private String creatorId;

    private String creatorFullName;

    private String title;

    private String description;

    private PollVersion lastVersion;

    private List<PollVersion> versions;



}
