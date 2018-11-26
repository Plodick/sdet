package com.simbirsoft.qaa.course.task3.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyInfo {

    private EmployerInfo employer;

    public EmployerInfo getEmployer() {
        return this.employer;
    }
}
