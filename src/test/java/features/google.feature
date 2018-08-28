Feature: Log in on googlemail and send an email
  As a regular user
  I want to log-in
  So I can send an email to a friend

  Scenario: Enter website and log-in
    Given I enter the website googlemail
    When I fill in login form
    Then I am logged in

  Scenario: Send email
    Given I am logged in on googlemail
    When I compose and send an email
    Then I am shown a success message