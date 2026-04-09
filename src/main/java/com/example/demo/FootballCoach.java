package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkOutSchedule() {
        return "Football training starts at 6:00 PM on Tuesdays and Thursdays.";
    }
}
