Feature: Demo new customer page

  @NewCustomer
  Scenario Outline: verifying new customer page
    Given user launch naveen automation lab "<URL>"
    When user click on new customer button
    Then user verify "<title>" of the page

    Examples:
      | URL                                                                     | title |
      | https://naveenautomationlabs.com/opencart/index.php?route=account/login | Books |