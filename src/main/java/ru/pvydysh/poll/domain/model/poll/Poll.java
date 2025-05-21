package ru.pvydysh.poll.domain.model.poll;

import lombok.Getter;
import lombok.Setter;
import ru.pvydysh.poll.domain.model.enums.PollStatus;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Poll {

    private UUID pollId;

    private PollStatus status;

    private List<PollVersion> versions;

    private String authorId;

    private String authorName;

}
