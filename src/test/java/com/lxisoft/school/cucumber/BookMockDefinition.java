package com.lxisoft.school.cucumber;

import com.lxisoft.school.mockito.BookResource;
import com.lxisoft.school.mockito.BookService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

public class BookMockDefinition {

    public BookService bookService;

    public BookResource bookResource;

    public List<String> combinedlist = new ArrayList<String>();

    public  List<String> hibernatecollection;


    @Given("I create a dummy mock object of BookService class")
    public void i_create_a_dummy_mock_object_of_BookService_class() {

        bookService = mock(BookService.class);

            }

    @When("I add some bookName as {string},{string},{string} and {string}  to an arrayList")
    public void i_add_some_bookName_as_and_to_an_arrayList(String string, String string2, String string3, String string4) {

        combinedlist.add(string);
        combinedlist.add(string2);
        combinedlist.add(string3);
        combinedlist.add(string4);

        when(bookService.getBooks("dummy")).thenReturn(combinedlist);

    }

    @When("if the arrayList contains {string} then add the book into another arrayList named hibernatecollection")
    public void if_the_arrayList_contains_then_add_the_book_into_another_arrayList_named_hibernatecollection(String string) {

        bookResource = new BookResource(bookService);
        hibernatecollection = bookResource.getBooksforHibernate("dummy");

    }

    @Then("verify the size of arrayList hibernatecollection")
    public void verify_the_size_of_arrayList_hibernatecollection() {

        System.out.println(hibernatecollection);
        assertEquals(1, hibernatecollection.size());
        System.out.println("//////////////////");
    }

}
