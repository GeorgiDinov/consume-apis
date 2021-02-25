package com.georgidinov.myapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MarkDTO {

    @JsonProperty("mark")
    private double mark;

    @JsonProperty("date")
    private String date;

    @JsonProperty("student_name")
    private String studentName;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("mark_url")
    private String markUrl;


    //== constructors ==
    public MarkDTO() {
    }

    public MarkDTO(double mark, String date, String studentName, String courseName, String markUrl) {
        this.mark = mark;
        this.date = date;
        this.studentName = studentName;
        this.courseName = courseName;
        this.markUrl = markUrl;
    }


    //== getters and setters
    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMarkUrl() {
        return markUrl;
    }

    public void setMarkUrl(String markUrl) {
        this.markUrl = markUrl;
    }
}