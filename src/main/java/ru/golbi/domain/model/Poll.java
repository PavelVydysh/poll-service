package ru.golbi.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Poll {

    private UUID pollId;

    private String creatorId;

    private String creatorFullName;

}
