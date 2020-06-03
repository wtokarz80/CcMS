package com.m3w.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Attendance {

    private Map<LocalDate, Boolean> calendar = new HashMap<>();

    public void addDailyAttendance(LocalDate date, boolean isPresent){
        this.calendar.put(date, isPresent);
    }

    public Map<LocalDate, Boolean> getCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Attendance:\n");
        for (LocalDate key : calendar.keySet()){
            builder.append(key.toString() + ": " + calendar.get(key).toString() + "\n");
        }

        return builder.toString();
    }
}
