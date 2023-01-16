Feature: Register user Reqres API
  @Tugas
  Scenario: Register new user with valid valid json
    Given Register user with valid json
    When Send request post register user
    Then Should return status code 200
#    And Response body email should be "eve.holt@reqres.in" and password "pistol"
    And Validate json schema register user
