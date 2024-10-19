package com.web_banking_application.banking;

import java.security.Key;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
public class appConfig {
	
	
    @Bean
    public String secretKey() {
        // Generate the secret key
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}

