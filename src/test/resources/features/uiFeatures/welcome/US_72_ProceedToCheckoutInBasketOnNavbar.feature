@UI @US_072

Feature: Operations in Basket-Proceed to checkout

  Scenario: TC_001
    Given user goes to homepage
    When user logs in as a Buyer
    When the user close the  zipcode window
    And user clicks on Notification icon on navbar
    Then user marks all notifications as read and get current notification count
    And user clicks the basket on the navbar
    Then user add product to the cart

    When user clicks Proceed to checkout button
    And user enters first name
    And user clicks Next button and verifies that give correct result
    And user clicks Prev button and verifies that give correct result
    Then user clicks Next button and verifies that give correct result


    When user clicks Go to Payment for entering Payment information
    When user clicks login button for going to Paypall
    And user clicks LoginPaypall
    And user enters Email
    And user enters password
    And user clicks loginButton
    Then user completes purchase
    Then user verifies that Payment successful is displayed

    When user clicks Rate Our Service
    And user clicks stars
    Then clicks submit button

    When user enters to the Order Detail Page
    And user clicks last added customer name and verifies that order detail is visible
    And user verifies that the status of the orders-In Progress-On Delivery-Completed are visible
    And user verifies that last added product is visible in buyer account
    Then user clicks last added order detail and verifies that last delivery info is visible

    When user clicks on Notification icon on navbar
   Then user verifies that as a result of orders the number in the notifications button increases


