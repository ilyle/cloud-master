package com.xiaoqi.cloudss.system;

import com.xiaoqi.cloudss.system.param.SystemParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class SsRunner implements ApplicationRunner{

    @Resource
    private SystemParam systemParam;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        printSystemConfig();
    }

    private void printSystemConfig() {
        String builder = "\r\n" +
                "********************************" + "\r\n" +
                String.format("[服务名称] : [%s]", systemParam.getApplicationName()) + "\r\n" +
                String.format("[环境类型] : [%s]", systemParam.getEnv()) + "\r\n" +
                String.format("[系统版本] : [%s]", systemParam.getVersion()) + "\r\n" +
                String.format("[更新时间] : [%s]", systemParam.getUpdateTime()) + "\r\n" +
                String.format("[服务端口] : [%s]", systemParam.getServerPort()) + "\r\n" +
                "********************************";
        log.info(builder);
    }
}
