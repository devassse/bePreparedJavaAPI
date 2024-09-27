package mz.co.keomagroup.bePreparedJavaAPI.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatsResponse {

    long citizens;
    long totalAlerts;
    long totalActiveAlerts;
}
