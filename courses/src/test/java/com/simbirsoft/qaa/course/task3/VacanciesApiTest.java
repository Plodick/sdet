package com.simbirsoft.qaa.course.task3;

import com.simbirsoft.qaa.course.task3.deserialization.VacancyEmployerInfo;
import com.simbirsoft.qaa.course.task3.helpers.VacancySearch;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class VacanciesApiTest {

    private String employerId;

    @BeforeTest
    public void setUp() throws IOException {
        Properties property = new Properties();
        property.load(new FileInputStream("src/main/resources/task3.properties"));
        employerId = property.getProperty("employerId");
    }

    @Test(description = "GET")
    public void searchVacancyByEmployerId() {
        List<VacancyEmployerInfo> vacancyEmployerInfos = VacancySearch
                .searchByEmployerId(employerId);
        for (VacancyEmployerInfo item : vacancyEmployerInfos) {
            Assert.assertEquals(item.getId(), employerId);
        }
    }
}
