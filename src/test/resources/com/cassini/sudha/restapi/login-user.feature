Feature: feature should allow user to login
  Scenario: user login successfully on providing valid credentials
    Given loaded "user-login-details-valid" payload
    When post api for "user_login" is called
    Then api should return response with status code "200"
    And "token" in response body should be "QpwL5tke4Pnpja7X4"

  Scenario: user login fails on providing invalid credentials
    Given loaded "user-login-details-invalid" payload
    When post api for "user_login" is called
    Then api should return response with status code "400"