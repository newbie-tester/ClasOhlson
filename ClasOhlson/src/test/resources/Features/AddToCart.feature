Feature: Add to cart
I want to verify that the correct amount of items are added in the shopping cart
  
Scenario: Add to cart
Given I have opened the superlim page
And I have changed the amount to 2
When I press add to cart
Then I should see 2 appears in the cart icon
    
