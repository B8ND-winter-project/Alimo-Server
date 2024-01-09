package com.b1nd.alimoserver;

import com.b1nd.alimoserver.global.properties.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties({JwtProperties.class})
public class AlimoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlimoServerApplication.class, args);
    }

}
