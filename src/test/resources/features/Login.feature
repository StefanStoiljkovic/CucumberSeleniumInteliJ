@loginFeature @regression
Feature: Web Driver University - Login verification

  Background:
    Given  access the webdriver university login page


  Scenario: Access with correct user name and password
    When  insert correct user name webdriver
    And  insert correct password webdriver123
    And  click Login button
    Then verify message "validation succeeded" is present

  Scenario: Access with correct user name and password

    When  insert correct user name wrongUSer
    And  insert correct password webdriver321
    And  click Login button
    Then verify message "validation failed" is present

    Scenario Outline: Access with correct/incorrect user name and password
      When  insert correct user name <userName>
      And  insert correct password <userPassword>
      And  click Login button
      Then verify message is present <expectedMessage>

      Examples:
      | userName | userPassword | expectedMessage |
      | webdriver| webdriver123 | validation succeeded|
      | webdriver1| webdriver3 | validation failed|
      | joeblack| wrongpassord | validation failed|





