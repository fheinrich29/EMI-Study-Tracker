package com.example.user.studytracker;

import java.util.Date;

/**
 * Created by User on 26/12/2017.
 */

public class Occasion {
    Date start;
    Date end;
    boolean attended;

        public Occasion(Date start, Date end, boolean attended){
            this.start = start;
            this.end = end;
            this.attended = attended;
        }
    }
