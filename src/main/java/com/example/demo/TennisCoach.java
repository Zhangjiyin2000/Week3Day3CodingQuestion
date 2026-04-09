package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private final Resource scheduleFile;
    private String[] schedules;

    public TennisCoach(@Value("${coach.tennis.schedule-file}") Resource scheduleFile) {
        this.scheduleFile = scheduleFile;
    }

    @PostConstruct
    public void loadSchedules() {
        this.schedules = readSchedules(scheduleFile);
    }

    @Override
    public String getDailyWorkOutSchedule() {
        int index = ThreadLocalRandom.current().nextInt(schedules.length);
        return schedules[index];
    }

    private String[] readSchedules(Resource resource) {
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> lines = reader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());

            if (lines.size() != 5) {
                throw new IllegalStateException("Tennis schedule file must contain exactly 5 schedules.");
            }

            return lines.toArray(new String[0]);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to read tennis schedules.", ex);
        }
    }
}
