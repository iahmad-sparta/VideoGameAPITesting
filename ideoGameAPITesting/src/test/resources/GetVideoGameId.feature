Feature:
  As a: User or system
  I want to: Retrieve details of a specific video game using its ID
  So that I can: View its information, such as name, category, rating, release date, and review score

  @Happy
  Scenario: I provide a valid id of an existing video game JSON:
    Given I have end point videogameid json with <2>
    When I specify the accept header with application json
    And I send GET HTTP request for JSON videogame by ID JSON
    Then The API returns a 200 OK response JSON.
    And The response body is in JSON format

  @Happy
  Scenario: I provide a valid id of an existing video game XML
    Given I have end point videogameid xml with <2>
    When I specify the Accept header with application xml
    And I send GET HTTP request for JSON videogame by ID XML
    Then The API returns a 200 OK responseXML.
    And The response body is in XML format.

    @Sad
    Scenario: Invalid Id given xml
      Given I have end point videogameid xml with <100000>
      When I specify the Accept header with application xml
      And I send GET HTTP request for JSON videogame by invalid id XML
      Then The API returns a 404 server error response XML.
      And The response body is in XML format.

  @Sad
  Scenario: Invalid Id given json
    Given I have end point videogameid json with <100000>
    When I specify the accept header with application json
    And I send GET HTTP request for JSON videogame by invalid id JSON
    Then The API returns a 404 server error response json
    And The response body is in JSON format