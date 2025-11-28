@login
Feature: User Authentication

  Background:
    Given the app is launched on the device

  @positive @smoke
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to the login page
    When the user enters "bod@example.com" into the username field
    And the user enters "10203040" into the password field
    And the user taps the Login button
    Then the user should see the Products page

  @negative
  Scenario: Failed Login with Invalid Credentials
    Given the user navigates to the login page
    When the user enters "alice@example.com" into the username field
    And the user enters "123456" into the password field
    And the user taps the Login button
    Then the user should see an error message

  @negative @validation
  Scenario: Login with Empty Username
    Given the user navigates to the login page
    When the user enters "" into the username field
    And the user enters "10203040" into the password field
    And the user taps the Login button
    Then the user should see a username error message

  @negative @validation
  Scenario: Login with Empty Password
    Given the user navigates to the login page
    When the user enters "bod@example.com" into the username field
    And the user enters "" into the password field
    And the user taps the Login button
    Then the user should see an error message
