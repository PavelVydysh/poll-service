package ru.golbi.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AvailableAnswers {

    private UUID availableAnswerId;

    private String title;

    private Integer position;

}
