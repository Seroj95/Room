package com.example.myapplicationasdd;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String descreption;
    private int dayOfWeek;
    private int priorety;

    public Note(int id, String title, String descreption, int dayOfWeek, int priorety) {
        this.title = title;
        this.descreption = descreption;
        this.dayOfWeek = dayOfWeek;
        this.priorety = priorety;
        this.id = id;

    }
@Ignore
    public Note(String title, String descreption, int dayOfWeek, int priorety) {
        this.title = title;
        this.descreption = descreption;
        this.dayOfWeek = dayOfWeek;
        this.priorety = priorety;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getPriorety() {
        return priorety;
    }

    public void setPriorety(int priorety) {
        this.priorety = priorety;
    }

    public static String getDayAsString(int position) {
        switch (position) {
            case 1:
                return "erkushabti";
            case 2:
                return "erekshabti";
            case 3:
                return "choreqshabti";
            case 4:
                return "hingshbti";
            case 5:
                return "urbat";
            case 6:
                return "shabat";
            default:
                return "kiraki";

        }

    }

}
