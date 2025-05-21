package ru.pvydysh.poll.api.dto.poll;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableAnswerRequestDto {

    private String title;

    private Integer position;

}
