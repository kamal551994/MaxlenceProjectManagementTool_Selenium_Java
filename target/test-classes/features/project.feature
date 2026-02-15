Feature: Project Management

  Background:
    Given User is on Login page
    When User logs in with username "Admin" and password "admin123"

  Scenario: Create a new project successfully
    And User navigates to Project module
    When User creates a new project
    Then Project creation should be successful
    And Project should appear in project listing