package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {

    @Override
    public String getDailyWorkOutSchedule() {
        return "Golf practice starts at 7:00 AM on weekdays.";
    }
}
