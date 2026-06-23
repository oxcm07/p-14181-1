package com.back.global.app;

import com.back.standard.util.Ut;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
    private static Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        AppConfig.environment = environment;
    }

    public static boolean isDev() {
        return environment.matchesProfiles("dev");
    }

    public static boolean isTest() {
        return !environment.matchesProfiles("test");
    }

    public static boolean isProd() {
        return environment.matchesProfiles("prod");
    }

    public static boolean isNotProd() {
        return !isProd();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Getter
    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        AppConfig.objectMapper = objectMapper;
    }

    //AppConfig의 생성과 의존성 주입이 모두 완료된 후, 딱 한 번 자동으로 실행되는 초기화 메서드
    @PostConstruct
    public void postConstruct() {
        Ut.json.objectMapper = objectMapper;
    }
}