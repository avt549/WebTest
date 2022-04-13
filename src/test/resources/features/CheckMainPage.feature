Feature: Check user date
  Scenario: Check user date
    Given Open browser "chrome"
    When Open page users
    When check that user date is visible
    Then Close browser

  Scenario: Check user grade
    Given Open browser "chrome"
    When Open page users
    When check that grade is visible
    Then Close browser

  Scenario: Check that that users more then 20
    Given Open browser "chrome"
    When Open page users
    When check that that users more then 20
    Then Close browser

  Scenario: Check user id
    Given Open browser "chrome"
    When Open page users
    When check that id is visible
    Then Close browser

  Scenario:  Check user name
    Given Open browser "chrome"
    When Open page users
    When check that name is visible
    Then Close browser