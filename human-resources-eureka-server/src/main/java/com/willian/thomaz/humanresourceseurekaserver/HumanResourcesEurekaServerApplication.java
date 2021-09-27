package com.willian.thomaz.humanresourceseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HumanResourcesEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanResourcesEurekaServerApplication.class, args);
    }

}
