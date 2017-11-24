package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


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
        Set<ContactData> before = app.contacts().all();
        ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Petrov").withIndexGroup(1);
        app.contacts().createContact(contact);
        Set<ContactData> after = app.contacts().all();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withContactId(after.stream().mapToInt((c) -> c.getContactId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);

    }


}
