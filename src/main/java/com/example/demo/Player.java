package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Player {

    private final Coach tennisCoach;
    private Coach golfCoach;

    @Autowired
    @Qualifier("footballCoach")
    private Coach footballCoach;

    public Player(@Qualifier("tennisCoach") Coach tennisCoach) {
        this.tennisCoach = tennisCoach;
    }

    @Autowired
    public void setGolfCoach(@Qualifier("golfCoach") Coach golfCoach) {
        this.golfCoach = golfCoach;
    }

    public String getTennisDailyWorkOutSchedule() {
        return tennisCoach.getDailyWorkOutSchedule();
    }

    public String getGolfDailyWorkOutSchedule() {
        return golfCoach.getDailyWorkOutSchedule();
    }

    public String getFootballDailyWorkOutSchedule() {
        return footballCoach.getDailyWorkOutSchedule();
    }
}
