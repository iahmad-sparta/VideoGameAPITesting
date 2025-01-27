package com.sparta.stepdefs;

import com.sparta.Utils;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoGameListStepdefs {
    Response response;
    RequestSpecification request;

    @Given("I have built a request with a JSON header")
    public void the_api_end_point_videogame() {
        request = Utils.getVideoGameList();
    }

    @When("I send GET HTTP request to API videogame")
    public void i_send_GET_http_request_to_api_videogame() {
        response = RestAssured
                .given(request)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @Then("I should receive a list of video games in a list")
    public void i_should_receive_a_list_of_video_games_in_a_list() {
        assertThat("Response body should not be null", response.getBody().asString(), is(not(emptyString())));
        assertThat("Response should contain a list of video games", response.jsonPath().getList("$"), is(not(empty())));
    }

    @And("I get 200 status code")
    public void i_get_200_status_code() {
        assertThat("Status code should be 200", response.getStatusCode(), is(200));
    }


    @And("the response body should contain a list of video games with attributes")
    public void theResponseBodyShouldContainAListOfVideoGamesWithAttributes() {
        // Verify each game object contains expected attributes
        response.jsonPath().getList("$").forEach(game -> {
            assertThat("Game should have an id", ((Map<?, ?>) game).get("id"), is(notNullValue()));
            assertThat("Game should have a name", ((Map<?, ?>) game).get("name"), is(notNullValue()));
            assertThat("Game should have a releaseDate", ((Map<?, ?>) game).get("releaseDate"), is(notNullValue()));
            assertThat("Game should have a reviewScore", ((Map<?, ?>) game).get("reviewScore"), is(notNullValue()));
            assertThat("Game should have a category", ((Map<?, ?>) game).get("category"), is(notNullValue()));
            assertThat("Game should have a rating", ((Map<?, ?>) game).get("rating"), is(notNullValue()));
        });
    }


    @Given("The API end-point api v2 videogame")
    public void theAPIEndPointApiVVideogame() {
        request = Utils.getVideoGameListV2();
    }

    @And("the response content type should be application json")
    public void theResponseContentTypeShouldBeApplicationJson() {
        String contentType = response.getHeader("Content-Type");
        assertThat("Content-Type should be application/json", contentType, is("application/json"));
    }

    @And("the response body should contain a list of video games as XML with elements")
    public void theResponseBodyShouldContainAListOfVideoGamesAsXMLWithElements() {
        // Fetch the XML response body
        String responseBody = response.getBody().asString();

        // Parse the XML using RestAssured's XMLPath
        XmlPath xmlPath = new XmlPath(responseBody);

        // Get a list of all item elements
        List<String> items = xmlPath.getList("List.item");

        // Assert that the list is not empty
        assertTrue(items.size() > 0, "The list of video games should not be empty.");

        for (int i = 0; i < items.size(); i++) {
            // Validate each element inside <item>
            String id = xmlPath.getString("List.item[" + i + "].id");
            String name = xmlPath.getString("List.item[" + i + "].name");
            String releaseDate = xmlPath.getString("List.item[" + i + "].releaseDate");
            String reviewScore = xmlPath.getString("List.item[" + i + "].reviewScore");
            String rating = xmlPath.getString("List.item[" + i + "].rating");

            // Validate category attribute
            String category = xmlPath.getString("List.item[" + i + "].@category");

            // Assertions to ensure all fields exist
            assertNotNull(id, "Item missing the 'id' element.");
            assertNotNull(name, "Item missing the 'name' element.");
            assertNotNull(releaseDate, "Item missing the 'releaseDate' element.");
            assertNotNull(reviewScore, "Item missing the 'reviewScore' element.");
            assertNotNull(rating, "Item missing the 'rating' element.");
            assertNotNull(category, "Item missing the 'category' attribute.");
        }
    }


    @And("the response content type should be application xml")
    public void theResponseContentTypeShouldBeApplicationXml() {
        String contentType = response.getHeader("Content-Type");
        assertThat("Content-Type should be application/xml", contentType, is("application/xml"));
    }

    @Given("I have built a request with a XML header")
    public void iHaveBuiltARequestWithAXMLHeader() {
        request = Utils.getVideoGameListXML();
    }

}





