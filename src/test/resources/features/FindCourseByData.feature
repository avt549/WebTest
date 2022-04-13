Feature: User Page Test

  Scenario: Check user date
    Given Open browser "chrome"
    When Open page users
    When Open page user
    When check that user date
    Then Close browser

  Scenario: Check user name
    Given Open browser "chrome"
    When Open page users
    When Open page user
    When check that user name
    Then Close browser

  Scenario: Check user grade
    Given Open browser "chrome"
    When Open page users
    When Open page user
    When check that user drade
    Then Close browser

  Scenario: Check user School Name
    Given Open browser "chrome"
    When Open page users
    When Open page user
    When check that user School Name
    Then Close browser

  Scenario: Check user City
    Given Open browser "chrome"
    When Open page users
    When Open page user
    When check that user City
    Then Close browser