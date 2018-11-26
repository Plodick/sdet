package com.simbirsoft.qaa.course.task3.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyInfoList {

    private List<VacancyInfo> items;

    public List<VacancyInfo> getList() {
        return this.items;
    }
}
