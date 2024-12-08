package ru.golbi.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Poll {

    private String title;

    private List<AvailableAnswer> availableAnswers;

}
