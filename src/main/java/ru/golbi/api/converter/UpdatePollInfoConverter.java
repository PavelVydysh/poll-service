package ru.golbi.api.converter;

import org.springframework.util.ObjectUtils;
import ru.golbi.api.dto.UpdatePollInfoRequestDto;
import ru.golbi.domain.model.UpdatePollInfo;

public class UpdatePollInfoConverter {

    public static UpdatePollInfo toUpdatePollInfo(UpdatePollInfoRequestDto updateInfoDto) {
        if(ObjectUtils.isEmpty(updateInfoDto)) {
            return null;
        }

        UpdatePollInfo updateInfo = new UpdatePollInfo();
        updateInfo.setClearDescription(updateInfoDto.getClearDescription());

        return updateInfo;
    }

}
