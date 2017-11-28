package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestContactDetails extends TestBase {

    @Test
    public void checkContactDetails() {
        app.goTo().homePage();
        ContactData contact = app.contacts().allFromHomePage().iterator().next();
        ContactData contactDataFromDetails = app.contacts().infoFromDetails(contact);

        assertThat(contact.getfName() + " " + contact.getlName(), equalTo(contactDataFromDetails.getFullName()));
        assertThat(contact.getAllEmails(), equalTo(mergedEmails(contactDataFromDetails)));


    }

    private String mergedEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

}
