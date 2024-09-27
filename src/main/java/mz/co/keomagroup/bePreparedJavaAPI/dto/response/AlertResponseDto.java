package mz.co.keomagroup.bePreparedJavaAPI.dto.response;

import lombok.Builder;
import lombok.Data;
import mz.co.keomagroup.bePreparedJavaAPI.model.enums.Severity;

@Data
@Builder
public class AlertResponseDto {

    private Long id;
    private String title;
    private String message;
    private boolean isActive;
    private Severity severity;
    private String province;
    private String city;

}
