Feature: Ebay Home Page Scenarios

  @P1
  Scenario: Advanced Search Link
    Given I am on Ebay home page
    When I click on advanced link
    Then I navigate to advanced search page

  @P2 @setCookies @Test
  Scenario: Search items count
    Given I am on Ebay home page
    When I search for 'iPhone 11'
    Then I validate at least 1000 search items present

  @P3 @setCookies
  Scenario: Search items count2
    Given I am on Ebay home page
    When I search for 'Toy Cars'
    Then I validate at least 100 search items present

  @P4 @setCookies
  Scenario: Search an item in category
    Given I am on Ebay home page
    When I search for 'soap' in 'baby' category

  @P5
  Scenario Outline: HomePage Links
    Given I am on Ebay home page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples:
      | link        | url                                                            | title       |
      | Motors      | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | eBay Motors |
      | Fashion     | https://www.ebay.com/b/Fashion/bn_7000259856                   | Fashion     |
      | Toys        | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys        |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124               | Electronics |