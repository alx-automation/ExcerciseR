Feature: Cart Page Detail

  @wip
  Scenario Outline: 1 - Verify total price and quantity for an item
    Given the user searched for item <keyword>
    When the user add first item to cart with quantity <itemQuantity>
    And go to cart page
    Then the user should see total price and quantity correctly
    Examples:
      | keyword        | itemQuantity |
      | "hats for men" | 2            |

  @wip
  Scenario Outline: 1 - Verify total price and quantity for an item after reduce quantity
    Given the user searched for item <keyword>
    When the user add first item to cart with quantity <itemQuantity>
    And go to cart page
    And change quantity of the item <newItemQuantity>
    Then the user should see total price and quantity correctly
    Examples:
      | keyword        | itemQuantity | newItemQuantity |
      | "hats for men" | 2            | 1               |