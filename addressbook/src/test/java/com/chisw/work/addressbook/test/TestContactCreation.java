package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestContactCreation extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        app.goTo().groupPage();
        if (! app.groups().isGroupsCreated()) {
            app.groups().createGroupInBeforeMethod();
        }
    }


    @Test
    public void checkContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contacts().all();
        File photo = new File("src/test/resources/image.jpg");
        System.out.println(photo.exists());
        ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Petrov").withPhoto(photo);
        app.contacts().createContact(contact);
        Contacts after = app.contacts().all();
        assertThat(after, equalTo(before.withAdded(contact.withContactId(after.stream().mapToInt((c) -> c.getContactId()).max().getAsInt()))));
        assertThat(after.size(), equalTo(before.size() + 1));
        }
}
