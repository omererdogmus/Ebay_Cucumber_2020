Feature: Ebay Advanced Search Page

  @P6
  Scenario: Ebay logo on advanced search page
    Given I am on Ebay advanced search page
    When I click on Ebay logo
    Then I am navigated to Ebay home page

  @P7 @setCookies
  Scenario: Advanced search an item
    Given I am on Ebay advanced search page
    When I advanced search an item
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 900 |
