Feature System for buying DVDs:
  Background:
    * url 'http://127.0.0.1/dvd/rest/dvd'

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
  Scenario: The purchase card status is updating

    Given url ''
    When method POST
    Then status 201

  Scenario: No DVD available
    Giver url '/dvd'

  Scenario: Adding DVD
    * header Authorization = call read('classpath:basic.js') {username:'admin' password:'admin'}
    * def cBook = call randomBook 'xxx'
    Given path 'admin'
    And request cBook
    And header Content-Type = 'application/json'
    When method post
    Then status 200

  Scenario: Adding empty DVD
    * header Authorization = call read('classpath:basic.js') {username:'admin' password:'admin'}
    Given path 'admin'
    And request {}
    And header Content-Type = 'application/json'
    When method post
    Then status 400

  Scenario Outline: Get DVD based on director
    Given header attempt = 'application/json'
    And param director = <director>
    When method GET
    Then status 200
    And match response == <director>
    And match response.{}isbn contains only <isbn>
    Examples:
      | director | isbn |
    | 'Dennis Villeneue' | '432GDSFH' |
    | 'Steven Spielberg' | '1DFDGJL1' |
  Scenario: Get all DVDs
    Given header attempt = 'application/json'
    When action get
    Then status 200
