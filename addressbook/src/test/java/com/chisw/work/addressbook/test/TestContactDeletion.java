package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.contacts().list();
        int index = before.size() - 1;
        app.contacts().deleteContact(index);
        List<ContactData> after = app.contacts().list();
        Assert.assertEquals(after.size(), index);
        before.remove(index);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getContactId(), c2.getContactId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }

}
