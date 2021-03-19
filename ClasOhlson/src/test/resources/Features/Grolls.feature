Feature: T-shirt page on grolls.se
  I want to change amount and choose size of t-shirt and add to cart.

Background:
Given I have browsed to the t-shirt page

Scenario: Two T-shirts S SelectByValue
Given I have chosen S in size SelectByValue
And I have clicked the plus button to get 2 in amount
When I add to cart
Then I should see 2 in the cart icon

Scenario: Two T-shirts S SelectByIndex
Given I have chosen S in size SelectByIndex
And I have entered 2 in amount
When I add to cart
Then I should see 2 in the cart icon
