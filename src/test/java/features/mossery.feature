Feature: Enter website, choose an item and buy the item
  As a customer
  I want to add an item to the cart
  So I can buy that item

  Scenario: Enter website and add item to cart
    Given I enter the website
    When I search for an item and select it
    Then I choose preferred options
    Then I add item to cart

  Scenario: Fill in checkout form
    Given I am in a cart and click checkout
    When I fill in checkout form
    Then I choose my shipping method
    Then I am redirected to pay form