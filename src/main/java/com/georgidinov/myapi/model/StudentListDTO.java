package com.georgidinov.myapi.model;


import java.util.List;

public class StudentListDTO {

    private List<StudentDTO> students;

    public StudentListDTO() {
    }

    public StudentListDTO(List<StudentDTO> students) {
        this.students = students;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
