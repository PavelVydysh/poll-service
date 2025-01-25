package ru.golbi.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPollRequestDto {

    private String title;

    private String description;

    private UpdatePollInfoRequestDto updateInfo;

}
