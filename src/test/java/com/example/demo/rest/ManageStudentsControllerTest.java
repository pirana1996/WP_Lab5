package com.example.demo.rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ManageStudentsControllerTest extends BaseIntegrationTest{

    @Test
    public void test_insert_new_student() {
        RestAssured.given().accept(ContentType.JSON)
                .accept(ContentType.JSON)
                .given()//String index, String name, String lastName, String studyProgramName
                    .parameters("index", "654321",
                            "name", "Alice", "lastName", "Armstrong", "studyProgramName", "KNI")
                .when()
                    .post("api/students")
                .then()
                .statusCode(201);

/*        given().accept(ContentType.JSON)
                .when()
                .log().all()
                .get("/hello_controller")
                .then()
                .log().all()
                .assertThat()
                .contentType(ContentType.HTML)
                .statusCode(HttpStatus.SC_OK)
                .body(is(not(isEmptyOrNullString())));
*/    }
}
