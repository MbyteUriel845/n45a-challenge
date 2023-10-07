package com.project.nasa.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyCounter {
    private int count;

    public void resetCount() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    @Scheduled(cron = "0 0 0 * * *") // Se ejecuta diariamente a las 12:00 AM
    public void dailyReset() {
        resetCount();
    }
}