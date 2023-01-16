Feature: Delete user Reqres API
  @Tugas
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 5  |
      | 10 |
