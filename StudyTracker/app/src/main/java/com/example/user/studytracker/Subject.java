package com.example.user.studytracker;


import java.io.Serializable;

public class Subject  implements Serializable{
    String name;
    Occasion[] lecture;
    Occasion[] exercise;
    Occasion[] dueDate;

    public Subject(String name,Occasion[] lecture,Occasion[] exercise,Occasion[] dueDate){
        this.name = name;
        this.lecture = lecture;
        this.exercise = exercise;
        this.dueDate = dueDate;
    }
}
