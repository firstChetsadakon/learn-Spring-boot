package com.firstcode.springboot.config;

import com.firstcode.springboot.common.Coach;
import com.firstcode.springboot.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() { // swimCoach() is  the bean id
        return new SwimCoach();
    }
}
