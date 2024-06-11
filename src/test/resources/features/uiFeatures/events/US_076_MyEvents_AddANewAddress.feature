Feature: US_076_MyEvents_AddANewAddress

    @UI
    Scenario:
      Given The user goes to home page and logs in as a seller
      Then user clicks My Events button
      Then user clicks Create New Event button
      And user enter a Title
      Then user clicks on Add button
      Then user enter an Address and click Enter
      Then user enter a zipcode
      And user clicks Submit button
#      And user verifies "Your address successfully added"
