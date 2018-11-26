package com.simbirsoft.qaa.course.task3.helpers;

import com.simbirsoft.qaa.course.task3.deserialization.VacancyInfoList;
import io.restassured.RestAssured;

public class VacancySearch {

    public static VacancyInfoList searchByEmployerId(String employerId, int statusCode) {
        String url = "https://api.hh.ru/vacancies";
        return RestAssured.given()
                .queryParam("employer_id", employerId)
                .when()
                .get(url)
                .then()
                .statusCode(statusCode)
                .extract()
                .as(VacancyInfoList.class);
    }
}
