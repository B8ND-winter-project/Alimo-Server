package com.b1nd.alimoserver.global.config.DAuth;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.DAuthBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DAuthConfig {
    @Value("${DAuth.clientId}")
    private String CLIENT_ID;

    @Value("${DAuth.clientId}")
    private String CLIENT_SECRET;

    @Bean
    public DAuth dauth() {
        return DAuthBuilder.create()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .build();
    }
}
