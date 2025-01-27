package com.sparta.stepdefs;

import com.sparta.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyOrNullString;

public class GetVideoGameIDStepDefs {

    Response response;
    RequestSpecification request;

    @Given("I have end point videogameid json with <{int}>")
    public void iHaveEndPointVideogameidJsonWith(int id) {
        request = Utils.getVideoGame_WithId_json(id);
    }

    @Given("I have end point videogameid xml with <{int}>")
    public void iHaveEndPointVideogameidXmlWith(int id) {
        request = Utils.getVideoGame_WithId_xml(id);
    }

    @When("I specify the accept header with application json")
    public void iSpecifyTheAcceptHeaderWithApplicationJson() {
        request.header("Accept", "application/json");
    }

    @And("I send GET HTTP request for JSON videogame by ID JSON")
    public void iSendGETHTTPRequestForJSONVideogameByIDJSON() {
        response = RestAssured
                .given(request)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @Then("The API returns a {int} OK response JSON.")
    public void theAPIReturnsAOKResponseJSON(int statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }

    @And("The response body is in JSON format")
    public void theResponseBodyIsInJSONFormat() {
        assertThat(response.getContentType(), containsString("application/json"));
        assertThat(response.getBody().asString(), not(emptyOrNullString()));
    }

    @Given("I have end point videogameid xml")
    public void iHaveEndPointVideogameidXml() {
        int id = 1;
        request = Utils.getVideoGame_WithId_xml(id);
    }

    @When("I specify the Accept header with application xml")
    public void iSpecifyTheAcceptHeaderWithApplicationXml() {
        request.header("Accept", "application/xml");

    }

    @Then("The API returns a {int} OK responseXML.")
    public void theAPIReturnsAOKResponseXML(int statusCode) {
        assertThat("Status code should match expected", response.getStatusCode(), is(statusCode));

    }

    @And("I send GET HTTP request for JSON videogame by ID XML")
    public void iSendGETHTTPRequestForJSONVideogameByIDXML() {
        response = RestAssured
                .given(request)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @And("The response body is in XML format.")
    public void theResponseBodyIsInXMLFormat() {
        assertThat(response.getContentType(), containsString("application/xml"));
        assertThat(response.getBody().asString(), not(emptyOrNullString()));
    }

    @And("I send GET HTTP request for JSON videogame by invalid id XML")
    public void iSendGETHTTPRequestForJSONVideogameByInvalidIdXML() {
        response = RestAssured
                .given(request)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @Then("The API returns a {int} server error response XML.")
    public void theAPIReturnsAServerErrorResponseXML(int statusCode) {
        assertThat("Status code should be " + statusCode, response.getStatusCode(), is(statusCode));
        assertThat("Response content type should be XML", response.getContentType(), containsString("application/xml"));
        assertThat("Response body should not be empty", response.getBody().asString(), is(not(emptyString())));
    }

    @And("I send GET HTTP request for JSON videogame by invalid id JSON")
    public void iSendGETHTTPRequestForJSONVideogameByInvalidIdJSON() {
        response = RestAssured
                .given(request)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @Then("The API returns a {int} server error response json")
    public void theAPIReturnsAServerErrorResponseJson(int statusCode) {
        assertThat("Status code should be " + statusCode, response.getStatusCode(), is(statusCode));
        assertThat("Response content type should be JSON", response.getContentType(), containsString("application/json"));
        assertThat("Response body should not be empty", response.getBody().asString(), is(not(emptyString())));
    }

}
