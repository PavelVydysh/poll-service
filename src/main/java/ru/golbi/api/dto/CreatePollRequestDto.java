package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePollRequestDto {

    private String creatorId;

    private String creatorFullName;

    private String title;

    private String description;

}
