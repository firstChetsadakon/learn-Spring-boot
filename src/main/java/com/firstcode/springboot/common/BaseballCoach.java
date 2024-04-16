package com.firstcode.springboot.common;

import org.springframework.stereotype.Component;


@Component
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("in constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice hitting for 30 minutes";
    }
}
