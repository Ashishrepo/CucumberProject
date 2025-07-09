Feature: DemoWebShop Application

@smoke
  Scenario: Register New User
    Given User is at DemoWebShop Home Page
    When User navigate to Register Page
    And user Enters the Registration Details for Gender "male"
    Then User verify new user is registered
    And User logut from DemoWeb shop



  @DemoWebShop @smoke
  Scenario: Login check
    Given User is at DemoWebShop Home Page
    When User enters valid credentials
    Then User verify Application logo
    And User logut from DemoWeb shop