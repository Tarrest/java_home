package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
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
        int index = before.size()- 1;
        ContactData contact = new ContactData().withFirstName("11new eqwrqwer 1").withLastName("123 new fgdgfgfgf");
        app.contacts().modifyContact(index, contact);
        List<ContactData> after = app.contacts().list();
        Assert.assertEquals(before.size(), after.size());
/*        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getContactId(), c2.getContactId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);*/

    }


}
