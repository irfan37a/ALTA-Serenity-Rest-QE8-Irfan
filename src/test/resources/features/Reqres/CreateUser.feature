Feature: Create user Reqres API

  @Tugas
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "irfan herianto" and job "QE Manager"
    And Validate json schema create user
