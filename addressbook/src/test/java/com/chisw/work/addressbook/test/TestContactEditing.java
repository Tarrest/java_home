package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestContactEditing extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        if (! app.contacts().isContactCreared()) {
            if (! app.groups().isGroupsCreated()) {
                app.goTo().groupPage();
                app.groups().createGroupInBeforeMethod();
                app.goTo().homePage();
            }
            app.contacts().createContactInBeforeMethod();
            app.goTo().homePage();
        }
    }

    @Test
    public void checkContactEditing() {

        Contacts before = app.contacts().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withContactId(modifiedContact.getContactId()).withFirstName("Modified2").withLastName("Modified2");
        app.contacts().modifyContact(contact);
        Contacts after = app.contacts().all();
        //Assert.assertEquals(before.size(), after.size());

        assertThat(after, equalTo(before.withAdded(modifiedContact)));
    }

}
