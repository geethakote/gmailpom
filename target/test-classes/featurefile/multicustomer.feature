Feature: Create a multiple customer for multiple users

  Scenario Outline: 
    Given open a "<bn>" browser
    And launch a site using "http://dashboard.stripe.com/login"
    When do login using "<uid>" and "<pwd>"
    Then customer tab should be displayed
    When add customer and verify
      | name       | email                     | discription |
      | geethak    | geethakote@gmail.com      | hi          |
      | geetak     | geethakarekallu@gmail.com | hello       |
      | dhanunjaya | dhanu.test@gmail.com      | hi          |
    When do a logout
    Then login page should be displayed
    When clouse browser

    Examples: 
      | bn     | uid                       | pwd           |
      | Firefox| geethakarekallu@gmail.com | abdulkalam143 |
      | Firefox| mutlurisaitarun@gmail.com | abdulkalam143 |
      | chrome | kiranputta007@gmail.com   | abdulkalam143 |
