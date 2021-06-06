Feature: feature should retrieve list of resources

  Scenario: user should retrieve the list of resources and validate if it is retrieved correctly
      When get api for "list_resources" is called
    Then api should return response with status code "200"
    And "page" in response body should be "1"
    And "data[0].id" in response body should be "1"
    And "data[0].name" in response body should be "cerulean"
    And "data[0].year" in response body should be "2000"
    And "data[0].color" in response body should be "#98B2D1"
    And "data[0].pantone_value" in response body should be "15-4020"





