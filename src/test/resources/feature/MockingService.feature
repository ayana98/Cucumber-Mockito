Feature: mocking BookService class
    Scenario: mocking BookService class with some mock data
        Given I create a dummy mock object of BookService class
        When I add some bookName as "Core Java","Spring Core ","Hibernate " and "Spring MVC "  to an arrayList
        And if the arrayList contains "Hibernate " then add the book into another arrayList named hibernatecollection
        Then  verify the size of arrayList hibernatecollection
