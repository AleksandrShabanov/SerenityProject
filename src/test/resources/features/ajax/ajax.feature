
Feature: feature to test ajax functionality

  Scenario: Enter two valid numbers, click ‘Sum’, wait for the result and check if the result is correct
    Given enters admin data
    And user clicks on 'Login' button
    When user at Home Page clicks on 'Ajax test page' AjaxLink
    And user at Ajax Page enters X '2' and Y '2'
    And user clicks on Sum button
    Then check if the result is correct if X '2' and Y '2'

  Scenario: Enter one valid number and one string (not a number), click ‘Sum’, wait for the result, and verify that the message ‘Incorrect data’ appears
    Given enters admin data
    And user clicks on 'Login' button
    When user at Home Page clicks on 'Ajax test page' AjaxLink
    And user at Ajax Page enters X '2' and Y 'two'
    And user clicks on Sum button
    Then check if incorrect result field equals 'Result is: Incorrect data'