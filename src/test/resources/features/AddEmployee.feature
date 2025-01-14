Feature: Adding an employee using different methods

  Background:
    #Given user is able to access HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM button
    And user clicks on Add Employee option

  @smoke @test
  Scenario: Adding an employee using hardcode data
    When user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @addemployee
  Scenario: Adding an employee using feature file
    And user enters data "andrey" and "ms" and "ziad"
    And user clicks on save button
    Then employee added successfully

  @example
  Scenario Outline: Adding multiple employees using feature file
    And user enters "<firstname>" and "<middlename>" and "<lastname>".
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      |andrew     |ms          |symonds   |
      |matthew    |ms          |hayden    |
      |steve      |ms          |smith     |

  @datatable
  Scenario: Adding employees using data table
    When user adds multiple employees using data table and verify them
    |firstName|middleName|lastName|
    |andrew   |ms        |symonds   |
    |matthew  |ms        |hayden    |
    |steve    |ms        |smith     |

  @excel
  Scenario: Adding employees using excel file
    When user adds employees from excel file and verify them







