@contact-us @regression
Feature: WebDriver University - Contact Us Page


  Scenario: Validate Successfull Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter unique last name
    And I enter a unique email address
    And I enter unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message


  Scenario: Validate Successfull Submission - Specific Data
    Given I access the webdriver university contact us page
    When I enter a specific name Joelki
    And I enter a specific last name Blogic
    And I enter a specific email address joe_blogs987@mail.com
    And I enter a specific message "How are you today?"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message