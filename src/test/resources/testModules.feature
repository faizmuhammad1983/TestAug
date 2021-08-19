Feature: Test addition using Google Calculator


@web
  Scenario Outline: Search some texts on google mentioned in example below
    Given Navigate the browser to application under test
    When Search field is found
    Then Search for "<text>" , fail if nothing comes up


    Examples:
      | text                  |
      | SQA Automation        |


  @same
  Scenario Outline: Search some texts on google mentioned in example below
    Given Navigate the browser to application under test
    When Search field is found
    Then Search for "<text1>" , fail if nothing comes up


    Examples:
      | text1                     |
      | Software Engineering      |
