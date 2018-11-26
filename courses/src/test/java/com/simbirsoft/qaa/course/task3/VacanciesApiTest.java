package com.simbirsoft.qaa.course.task3;

import com.simbirsoft.qaa.course.task3.deserialization.VacancyInfo;
import com.simbirsoft.qaa.course.task3.deserialization.VacancyInfoList;
import com.simbirsoft.qaa.course.task3.helpers.VacancySearch;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VacanciesApiTest {

    private String employerId;

    private int statusCode;

    @BeforeTest
    public void setUp() throws IOException {
        Properties property = new Properties();
        property.load(new FileInputStream("src/main/resources/task3.properties"));
        employerId = property.getProperty("employerId");
        statusCode = Integer.parseInt(property.getProperty("statusCode"));
    }

    @Test(description = "GET")
    public void searchVacancyByEmployerId() {
        VacancyInfoList vacancyEmployerInfoList = VacancySearch
                .searchByEmployerId(employerId, statusCode);
        for (VacancyInfo item : vacancyEmployerInfoList.getList()) {
            Assert.assertEquals(item.getEmployer().getId(), employerId);
        }
    }
}
