@UI @US_052
Feature: Perform various actions in the Address section
    Background:
        Given user goes to homepage
        When user logs in as a seller
        And user clicks Address
        #And the user clicks only on Add New Address button and enter a city

        Scenario:  US_052 Address Title, Address,Post/Zip and Mark as delivery address,Mark as sales address options should appear
            And the user clicks only on Add New Address button and enter a city
            Then user verifies that the following web elements are visible and functional
            | addressTitle | address | postal | isDefault | isSellerAddress | button | submit |

        Scenario: US_052 State and City input boxes are not functional
            And the user clicks only on Add New Address button and enter a city
            Then verify title as State is not enabled
        Then verify title as City is not enabled

        Scenario: US_052 Address Title, Address, State,City, Post/Zip and Mark as delivery address,Mark as sales address options should appear
            And the user clicks only on Add New Address button and enter a city
            Then verify titles
        | addressTitle | address | states | citiesDataIdAddAddress | postal | isDefault | isSellerAddress |

        Scenario:US_052 Address Title, Address,Post/Zip should input
            Then verify input home,office etc. in Adress Title
            Then verify input an adress in Address
            Then verify input a postalzip in PostalZip


    Scenario: US_052 After adding the address, the warning Your address has been successfully added should appear.
        And the user clicks only on Add New Address button and enter a city1
        And check off Mark as a delivery address
        And clicks on the Submit button
        Then verify the "Your Address successfully added" should appear in address page
        Then verify address in relevant section for delivery

    Scenario: US_052 The added address should appear in the relevant section according to the selected transaction (Delivery address or My Sales address)

        And the user clicks on the Remove button in the My Delivery Adress
        And the user clicks only on Add New Address button and enter a city
      #  And check off Mark as a delivery address
#        And clicks on the Submit button1
#        Then verify address in relevant section
#        And the user clicks on the Remove button in the My Delivery Adress
#
    Scenario: US_052 - TC_005 The added address should appear in the relevant section according to the selected transaction (Delivery address or My Sales address)

        And remove
        And the user clicks only on Add New Address button and enter a city
       # And user enters a zipcode
        #And check off Mark as a sales address
        #And clicks on the Submit button
        #Then verify the "Your Address successfully added" should appear in address page
        #Then verify address in relevant section for sales
        #And the user clicks on the Remove button in the My Sales Adress

