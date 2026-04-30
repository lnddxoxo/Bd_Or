package org.example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String course_id;
    private String title;
    private Department dept;
    private double credits;
    private List<Course> prereqs;

    public Course(String course_id, String title,
                  Department dept, double credits) {
        this.course_id = course_id;
        this.title = title;
        this.dept = dept;
        this.credits = credits;
        this.prereqs = new ArrayList<>();
    }

    public String getCourseId()      { return course_id; }
    public String getTitle()         { return title; }
    public Department getDept()      { return dept; }
    public double getCredits()       { return credits; }
    public List<Course> getPrereqs() { return prereqs; }
    public void setCredits(double credits) { this.credits = credits; }
    public void addPrereq(Course cours)    { prereqs.add(cours); }

    public int getNbPrerequis()  { return prereqs.size(); }
    public boolean aPrerequis()  { return !prereqs.isEmpty(); }

    @Override
    public String toString() {
        return "Course[" + course_id + ", " + title +
                ", " + credits + " credits, " +
                getNbPrerequis() + " prereqs]";
    }
}