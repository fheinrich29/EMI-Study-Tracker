package com.example.user.studytracker;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by User on 30/12/2017.
 */

public class EventRule implements Serializable {
    boolean repeating;
    Calendar startDate;
    Calendar endDate;
    int type;
    int increment;
    int dayOfWeek;
    Calendar startTime;
    Calendar endTime;

    public EventRule(boolean rep, Calendar startD, Calendar endD, int type, int inc, int dayOfWeek,
                     Calendar startTime, Calendar endTime){
        this.repeating = rep;
        this.startDate = startD;
        this.endDate = endD;
        this.type = type;
        this.increment = inc;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String toString(){
        return "type"+type+" startDate "+startDate;
    }
}
