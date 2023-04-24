package com.abdelhalim.egypt.clinics.api.clinic;

//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class UserControllerTest {
//    private static final String BASE_URL = "http://localhost:8080/api/doctor";
//
//    RequestSpecification requestSpec = new RequestSpecBuilder()
//            .setBaseUri(BASE_URL)
//            .addFilter(new RequestLoggingFilter())
//            .addFilter(new ResponseLoggingFilter())
//            .build();
//
//    @Test
//    void testGetAllDoctors() {
//        RestAssured.given()
//                .spec(requestSpec).given().contentType(ContentType.JSON)
//                .body("""
//                          "page": 0,
//                          "size": 10,
//                          "sort": [
//                            "ASC"
//                          ]
//                        }""")
//                .when()
//                .get("/page-query")
//                .then()
//                .statusCode(200);
//    }
//}
