Feature: List user Reqres API
  @Tugas
  Scenario Outline: Get list user with valid parameter page resres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    And Validate json schema list user
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario: Get list user with invalid parameter page
    Given Get list user with page 100
    When Send request get list user
    Then Should return status code 400

  @Tugas
  Scenario: Get list user with invalid parameter page string
    Given Get list user with page "satu"
    When Send request get list user
    Then Should return status code 400

  @Tugas
  Scenario: Get single user by id
    Given Get list user with id 3
    When Send request get user
    Then Should return status code 200

  @Tugas
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 5  |
      | 10 |
