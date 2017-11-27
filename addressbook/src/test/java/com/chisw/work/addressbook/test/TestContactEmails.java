package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestContactEmails extends TestBase {

    @Test
    public void checkContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contacts().allFromHomePage().iterator().next();
        ContactData contactDataFromEditForm = app.contacts().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((e) -> ! e.equals(""))
            .collect(Collectors.joining("\n"));
    }

}
