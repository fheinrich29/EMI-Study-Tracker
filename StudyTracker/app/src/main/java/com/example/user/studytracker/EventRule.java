package com.example.user.studytracker;

import java.util.Calendar;

/**
 * Created by User on 30/12/2017.
 */

public class EventRule {
    boolean repeating;
    Calendar startDate;
    Calendar endDate;
    int type;
    int increment;
    int dayOfWeek;
    int startHour;
    int endHour;
    int startMinute;
    int endMinute;

    public EventRule(boolean rep, Calendar startD, Calendar endD, int type, int inc, int dayOfWeek,
                     int startHour, int endHour, int startMinute, int endMinute){
        this.repeating = rep;
        this.startDate = startD;
        this.endDate = endD;
        this.type = type;
        this.increment = inc;
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
        this. endHour = endHour;
        this. startMinute = startMinute;
        this.endMinute = endMinute;
    }
}
