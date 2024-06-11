#@UI @US_070
#Feature: As a user, after entering valid information, I should be able to perform various actions in the Welcome Page
#
#  Scenario: TC_001-Order statuses must be seen in mutual buyer-seller accounts as a buyer
#    Given user goes to home page and logs in with Buyer ENUM
##    Then user verifies to see Orders in buyer-seller account
#
#  Scenario: TC_007-Order statuses must be seen in mutual buyer-seller accounts as a seller
#    Given user goes to home page and logs in with Seller ENUM
##    Then user verifies to see Orders in buyer-seller account
#
#
#  Scenario: TC_002-Your order placed messages should be seen in the basket in the buyer account, and You have a new order messages in the seller account.
#    And user hovers basket icon
#    Then user verifies to see order message in mutual buyer-seller accounts
#
#  Scenario: TC_003-Seller, order status should be updated in cart
#    And user clicks on basket icon with seller information
#    And user selects any product with seller information
#    And user clicks on 'PROCEED TO CHECKOUT' button with seller information
#    And user clicks on all 'NEXT' buttons with seller information
#    And user clicks on all 'Go To Payment' button with seller information
#    And user clicks on 'Complete Purchase' button with seller information
#    Then user verifies to update order status with payment succesful with seller information
#
#  Scenario: TC_004-As a result of updating the order status, the order status should be updated in the buyer's account.
#    And user clicks on basket icon with buyer information
#    And user selects any product with buyer information
#    And user clicks on 'PROCEED TO CHECKOUT' button with buyer information
#    And user clicks on all 'NEXT' buttons with buyer information
#    And user clicks on all 'Go To Payment' button with buyer information
#    And user clicks on 'Complete Purchase' button with buyer information
#    Then user verifies to update order status with payment succesful with buyer information
#
#  Scenario: TC_005-Mark all as read button and X button must be functional on buyer and seller accounts
#    And user clicks Notification bell
#    Then user verifies is enable the Mark all as read button
#
#  Scenario: TC_006-Mark all as read button and X button should give correct results in buyer and seller accounts
#    And user clicks Notification bell
#    And user clicks Mark all as read button
#    Then user verifies to see Notification empty container after click Mark all as read button and X button
#
