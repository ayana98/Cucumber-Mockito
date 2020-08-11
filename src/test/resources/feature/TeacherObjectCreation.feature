Feature: Object Creation
    Scenario Outline: Creating a teacher with valid inputs
        Given I create a new teacher
        When I enter name as "<name>" phoneNumber as "<phoneNumber>" and email as "<email>"
        Then  I get name as "<name>" phoneNumber as "<phoneNumber>" and email as "<email>"

        Examples:
            | name     |  phoneNumber   |  email               |
            | avika    | 9539539587     |  avika@gmail.com     |
            | aarushi  | 9846240101     |  aarushi@gmail.com   |
