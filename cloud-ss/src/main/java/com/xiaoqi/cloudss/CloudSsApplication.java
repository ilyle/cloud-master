package com.xiaoqi.cloudss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudSsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSsApplication.class, args);
	}

}
