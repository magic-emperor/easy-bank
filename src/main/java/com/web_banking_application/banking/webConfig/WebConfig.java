package com.web_banking_application.banking.webConfig;

//package com.web_banking_application.banking.Security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app/","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("https://easy-online-bank.netlify.app/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials (important for auth)
    }
}

