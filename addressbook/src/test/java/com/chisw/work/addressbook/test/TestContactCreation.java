package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


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
        List<ContactData> before = app.contacts().list();
        ContactData contact1 = new ContactData().withFirstName("44 new Name").withLastName("33 new name 2").withIndexGroup(1);
        app.contacts().createContact(contact1);
        List<ContactData> after = app.contacts().list();
        Assert.assertEquals(after.size(), before.size()+1);
        before.add(contact1);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getContactId(), c2.getContactId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);

    }

}
