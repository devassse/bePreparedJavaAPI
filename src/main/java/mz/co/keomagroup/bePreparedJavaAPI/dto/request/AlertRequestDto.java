package mz.co.keomagroup.bePreparedJavaAPI.dto.request;

import lombok.Data;
import mz.co.keomagroup.bePreparedJavaAPI.model.enums.Severity;

@Data
public class AlertRequestDto {

    private String title;
    private String message;
    private Severity severity;
    private Long provinceId;
    private Long cityId;

}
