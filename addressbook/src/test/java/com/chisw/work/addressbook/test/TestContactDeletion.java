package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class TestContactDeletion extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        if (! app.contacts().isContactCreared()) {
            app.goTo().groupPage();
            if (! app.groups().isGroupsCreated()) {
                app.groups().createGroupInBeforeMethod();
                app.goTo().homePage();
            }
            app.contacts().createContactInBeforeMethod();
            app.goTo().homePage();
        }
    }


    @Test
    public void checkContactDeletion() {
        app.goTo().homePage();
        Set<ContactData> before = app.contacts().all();
        ContactData deletedContact = before.iterator().next();
        app.contacts().deleteContact(deletedContact);
        Set<ContactData> after = app.contacts().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(after, before);
    }

}
