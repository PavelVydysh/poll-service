package ru.pvydysh.poll.domain.model.poll;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PollVersion {

    private UUID pollVersion;

    private String title;

    private List<AvailableAnswer> availableAnswers;

    private LocalDate creationDate;

    public PollVersion() {
        this.creationDate = LocalDate.now();
    }

}
