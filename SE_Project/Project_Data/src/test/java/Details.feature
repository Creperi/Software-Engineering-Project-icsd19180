Feature System for buying DVDs:
  Scenario: An user enters his username and password to get access to the system
    Given url ''
    When method GET
    Then status 200
  Scenario: Customer orders a DVD
    Given url 'localhost::3308'
    Then status 200
  Scenario: The order status is updating

    Given url ''
    When method POST
    Then status 201
  Scenario: The purchase card status is updating:

    Given url ''
    When method POST
    Then status 201
  Scenario: Payment failed:
    When method
    Then status 400
  Scenario: Customer Cancels order
    Given
    When method
    Then status

