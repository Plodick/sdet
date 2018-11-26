package com.simbirsoft.qaa.course.task3.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployerInfo {

    private String id;

    public String getId() {
        return this.id;
    }
}
