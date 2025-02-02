package com.sparta;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthentificationTest {

    static Response response;


    @BeforeAll
    public static void setup() {
        response = RestAssured
                .given(Utils.getAuthenticatedRequest())
                .when()
                .post()
                .then().extract().response();


    }


    @Test
    @DisplayName("Status code 200")
    public void statusCode200() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }


    // Defect - should be 400 but returns 403
    @Test
    @DisplayName("Status code 400")
    public void statusCode400() {
        MatcherAssert.assertThat(
                RestAssured.given(Utils.getAuthenticatedRequestWrongBody())
                        .when().log().all()
                        .post()
                        .then().extract().response().statusCode()
                , Matchers.is(400));
    }



}
