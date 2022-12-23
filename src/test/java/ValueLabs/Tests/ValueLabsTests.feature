@tag
Feature: TV Subscription

  @Regression
  Scenario Outline: Validating subscription packages for different countries
    Given User is landed on subscription page
    When User selects country <countrylabel> from the country dropdown
    Then Country <country> is selected and Subscription package type <type>, price <price> and currency <currency> are updated
    
       Examples: 
      | country   |   countrylabel |type 		 | price  | currency |
      | Iraq      |   iq           |CLASSIC  | 900.00 |  IQ      |
      | Jordan    |   jo           |CLASSIC  | 0.99   |  JOD     |
      | Tunisia   |   tn           |CLASSIC  | 1.00   |  TND     |

