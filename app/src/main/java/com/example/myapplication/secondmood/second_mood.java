package com.example.myapplication.secondmood;

import com.google.firebase.database.Exclude;

public class second_mood {

    String happy;
    String relax;
    String angry;
    String sad;
    String tag;
    String grade;
    String date;

    public second_mood(){}

    public second_mood(String happy,String relax,String angry,String sad,String tag) {
        this.happy = happy;
        this.relax= relax;
        this.angry = angry;
        this.sad= sad;
        this.tag=tag;

    }

    public String getHappy() {
        return happy;
    }

    public void setHappy(String happy) {
        this.happy = happy;
    }

    public String getRelax() {
        return relax;
    }

    public void setRelax(String relax) {
        this.relax = relax;
    }

    public String getAngry() {
        return angry;
    }

    public void setAngry(String angry) {
        this.angry = angry;
    }

    public String getSad() {
        return sad;
    }

    public void setSad(String sad) {
        this.sad = sad;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
