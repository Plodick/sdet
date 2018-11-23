package com.simbirsoft.qaa.course.task3.helpers;

import com.simbirsoft.qaa.course.task3.deserialization.VacancyEmployerInfo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.List;

public class VacancySearch {

    public static List<VacancyEmployerInfo> searchByEmployerId(String employerId) {
        String url = "https://api.hh.ru/vacancies?employer_id=";
        JsonPath jsonPath = RestAssured.given()
                .when()
                .get(url + employerId)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .extract()
                .body()
                .jsonPath();
        return jsonPath.getList("items.employer", VacancyEmployerInfo.class);
    }
}
