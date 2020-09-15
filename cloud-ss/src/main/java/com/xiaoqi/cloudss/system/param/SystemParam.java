package com.xiaoqi.cloudss.system.param;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class SystemParam {

    @Value("${spring.profile.active}")
    private String profile = "";

    @Value("${spring.application.name}")
    private String applicationName = "";

    @Value("${spring.cloud.client.ipAddress}")
    private String serverIp = "";

    @Value("${server.port}")
    private String serverPort = "";

    @Value("${system.env}")
    private String env = "";

    @Value("${system.version}")
    private String version = "";

    @Value("${system.updatetime}")
    private String updateTime = "";
}
