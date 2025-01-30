package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePollRequestDto {

    private String creatorUserId;

    private String creatorFullName;

    private String title;

    private String description;

}
