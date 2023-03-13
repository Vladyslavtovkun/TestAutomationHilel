@ui
Feature: Home page
  As a user,
  I want to open Home page and do smth

  Background:
    Given I am on the Home page

  @smoke @issue=TEST12345 @link=https://example.com
  Scenario: Open Home page
    When Click free consult button
    Then I can see Free Consult button

#    Scenario Outline: Open Home page
#      Given I am on the <pageName> page
#      Then I can see Free Consult button
#      Examples:
#        | pageName    |
#        | Home        |
#        | FreeConsult |

      @criticalPath
      Scenario Outline: Verify can fill free consult details
        Given I am on the FreeConsult page
        When I fill the following parameters:
        |name|email|phone|messenger|course|
        |<name>|<email>|<phone>|<messenger>|<course>|
        Then Information is found
        @smoke
        Examples:
          |name|email|phone|messenger|course|
          |John|john@gmail.com|1234567|tg|PHP|
        @regression
        Examples:
          |name|email|phone|messenger|course|
          |Bob|bob@gmail.com|1234568|tg|JS|