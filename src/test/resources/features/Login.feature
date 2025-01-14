Feature: Login based scenarios

  @smoke @sprint1 @sohel @tekia @invalid
  Scenario: Valid admin login
   # Given user is able to access HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page

  @invalid
  Scenario: Invalid login scenario
    When user enters invalid username and password
    And user clicks on login button
    Then user is able to see error message



