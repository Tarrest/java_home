package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.contacts().all();
        ContactData deletedContact = before.iterator().next();
        app.contacts().deleteContact(deletedContact);
        Contacts after = app.contacts().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withoutAdded(deletedContact)));
    }
}
