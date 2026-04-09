package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final Player player;

    public DemoApplication(Player player) {
        this.player = player;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Tennis: " + player.getTennisDailyWorkOutSchedule());
        System.out.println("Golf: " + player.getGolfDailyWorkOutSchedule());
        System.out.println("Football: " + player.getFootballDailyWorkOutSchedule());
    }
}
