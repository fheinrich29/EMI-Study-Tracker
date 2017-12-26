package com.example.user.studytracker;



public class Subject {
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
