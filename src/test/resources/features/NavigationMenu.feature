
Feature: Navigation Menu



@vip
Scenario: Navigating to menu
  Given the user is on the home page
  When  the user navigate to menu
  And  the user click the aboutUs
  Then the title should be MEET OUR TEAM