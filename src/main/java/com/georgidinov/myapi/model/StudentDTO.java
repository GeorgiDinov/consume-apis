package com.georgidinov.myapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {


    @JsonProperty("student_name")
    private String name;


    @JsonProperty("student_url")
    private String studentUrl;


    public StudentDTO() {
    }

    public StudentDTO(String name, String studentUrl) {
        this.name = name;
        this.studentUrl = studentUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentUrl() {
        return studentUrl;
    }

    public void setStudentUrl(String studentUrl) {
        this.studentUrl = studentUrl;
    }
}
