Feature: BDK Example

  Scenario: Authentication
    Given a bot
    When bot authenticates
    Then a session is created
