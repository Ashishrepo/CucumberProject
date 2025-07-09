Feature: nopCommerce Customer

  Scenario: Add a new Customer
    Given User open URL "https://admin-demo.nopcommerce.com/login"
    When User enter Email as "admin@yourstore.com" and Password as "admin"
    And user click on signIN btn
    Then user verify login is successfull
