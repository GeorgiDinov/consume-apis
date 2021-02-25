package com.georgidinov.myapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MarkListDTO {

    @JsonProperty("marks")
    private List<MarkDTO> marks;


    public MarkListDTO() {
    }

    public MarkListDTO(List<MarkDTO> marks) {
        this.marks = marks;
    }

    public List<MarkDTO> getMarks() {
        return marks;
    }

    public void setMarks(List<MarkDTO> marks) {
        this.marks = marks;
    }
}