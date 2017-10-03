package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
        app.goTo().homePage();
        List<ContactData> before = app.contacts().list();
        int index = before.size() - 1;
        app.contacts().modifyContact(index);
        List<ContactData> after = app.contacts().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
    }

}
