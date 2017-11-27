package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestContactPhones extends TestBase {

    @Test
    public void checkContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contacts().allForPhone().iterator().next();
        ContactData contactInfoFromEditForm = app.contacts().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobPhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(TestContactPhones :: cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return  phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
