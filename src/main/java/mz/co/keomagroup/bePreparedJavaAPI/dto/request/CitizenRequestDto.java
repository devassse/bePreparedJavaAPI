package mz.co.keomagroup.bePreparedJavaAPI.dto.request;

import lombok.Data;

@Data
public class CitizenRequestDto {

    private String phone;
    private String deviceId;
    private Long cityId;

}
