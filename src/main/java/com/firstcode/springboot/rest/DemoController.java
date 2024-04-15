package com.firstcode.springboot.rest;

import com.firstcode.springboot.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    //if it's having 1 injection this is optional for the constructor, but it is a good practice to use it
    // but i will keep it for now to be explicit about the dependency injection if it is one injection only
    @Autowired
    DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    //define endpoint for "/hello"
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
