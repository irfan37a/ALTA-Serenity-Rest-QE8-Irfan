Feature: Testing Reqres API ALTA QE8

  @Latihan
  Scenario Outline: Get list user with valid parameter page resres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
  Examples:
    | page |
    | 1    |
    | 2    |

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "irfan herianto" and job "QE Manager"
    And Validate json schema create user

  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "irfan herianto" and job "QE Manager"
    And Validate json schema update user

  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |