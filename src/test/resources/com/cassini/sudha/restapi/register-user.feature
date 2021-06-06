Feature: feature should register new user to application
  Scenario: user should be registered successfully on providing valid payload
    Given loaded "user-registration-valid" payload
    When post api for "user_registration" is called
    Then api should return response with status code "200"
    And "id" in response body should be "4"
    And "token" in response body should be "QpwL5tke4Pnpja7X4"

  Scenario: user should NOT be registered on providing invalid payload
    Given loaded "user-registration-invalid" payload
    When post api for "user_registration" is called
    Then api should return response with status code "400"