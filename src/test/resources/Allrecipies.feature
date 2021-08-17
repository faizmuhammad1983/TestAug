Feature: Test addition using Google Calculator


@web
  Scenario Outline: find a recipe
    Given Navigate the browser to application under test
    When Search field is found
    Then Search for "<Recipes>" , fail if nothing comes up


    Examples:
      | Recipes            |
      | Chicken Soup       |


  @same
  Scenario Outline: find a recipe 2
    Given Navigate the browser to application under test
    When Search field is found
    Then Search for "<Recipes>" , fail if nothing comes up


    Examples:
      | Recipes            |
      | Chicken      |
