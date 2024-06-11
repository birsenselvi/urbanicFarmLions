# As a user, when i should add new promo code
# then I Should be able to see promo code information
# in the correct  schema and columns in DB

@DB @dbRegression
Feature: Add new promo code then see the promo code information in DB
  Scenario: New Promo Code
    When Add new promo code
    Then verify that new promo code is in the DataBase

