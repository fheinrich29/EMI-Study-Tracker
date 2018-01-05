package com.example.user.studytracker;


import java.io.Serializable;
import java.util.List;

public class Subject  implements Serializable{
    String name;
    List<Occasion> lecture;
    List<Occasion>  exercise;
    List<Occasion>  dueDate;

    public Subject(String name,List<Occasion>  lecture,List<Occasion>  exercise,List<Occasion>  dueDate){
        this.name = name;
        this.lecture = lecture;
        this.exercise = exercise;
        this.dueDate = dueDate;
    }

    public String toString(){
        return "name: "+name+" number of occasions"+(lecture.size()+exercise.size()+dueDate.size())+".";
    }
}
