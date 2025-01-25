package ru.golbi.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Poll {

    private final static Integer DEFAULT_VERSION_NUMBER = 1;
    private final static Integer VERSION_INCREMENT_VALUE = 1;

    private UUID pollId;

    private String creatorUserId;

    private String creatorFullName;

    private String title;

    private String description;

    private PollVersion lastVersion;

    private List<PollVersion> versions = new ArrayList<>();

    public void createNewVersion(List<AvailableAnswer> availableAnswers) {
        PollVersion newVersion = new PollVersion();
        newVersion.setAvailableAnswers(availableAnswers);

        if (ObjectUtils.isEmpty(lastVersion)) {
            newVersion.setVersionNumber(DEFAULT_VERSION_NUMBER);
        } else {
            newVersion.setVersionNumber(
                    lastVersion.getVersionNumber() + VERSION_INCREMENT_VALUE
            );
        }

        versions.add(newVersion);
        lastVersion = newVersion;
    }

}
