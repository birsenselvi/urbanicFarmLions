#Enter prome code menu should be functional
#Code must be entered in the Enter prome code menu
#After entering the code, click the Apply button.
#After the code is entered, the code rate should give results
@UI @DB @US71
Feature: Welcome Page Promo Code

  Scenario Outline: TC_001_As a user, after entering valid information, I should be able to perform various actions in the Welcome Page
    Given delete used promocode
    Given user goes to homepage
    When user logs in as buyer
    And Cart empty
    And Add product to cart
    And user clicks on Cart
    Then Enter promo code menu should be functional
    And user calcule total and subtotal
    When Code enter in the Enter "<promo_code>" menu
    And Click the Apply button.
    Then assert toast message "<toastMessage>" if it is "<valid>"
    Then After the code is entered, the code rate should give results has "<type>" and amount is "<amount>" if it is "<valid>"

#    And Prome code must not be greater than or equal to the total amount
#    And After entering the promecode that is greater than or equal to the total amount, the alert should appear.
#    And Alert: You can't apply this promecode due to greater or equal than your total amount
#    And Post payment promecode should show correct result
#    And Undefined promecode cannot be entered
#    And Undefined promecode code soner Invalid Prome-Code. No such prome code is defined. alert should appear

  #  Then proceed from the Proceed to checkout button and complete the payment.

    Examples: promocode test data
      | promo_code   | type       | amount | toastMessage                                                                  | valid |
      | dolar10      | money      | 10     |                                                                               | true  |
      | percentage10 | percentage | 10     |                                                                               | true  |
      | dolar30      | money      | 30     | You can't apply this promocode due to greater or equal than your total amount | false |
      | naber        | money      | 0      | Invalid Promo-code.No such promo code is defined                              | false |
