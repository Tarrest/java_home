package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestContactModification extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        if (! app.contacts().isContactCreared()) {
            if (app.db().groups().size() == 0) {
                app.goTo().groupPage();
                app.groups().createGroupInBeforeMethod();
            }
            app.goTo().homePage();
            app.contacts().createContactInBeforeMethod();
            app.goTo().homePage();
        }
    }

    @Test
    public void checkContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withContactId(modifiedContact.getContactId()).withFirstName("Modified3").withLastName("Modified3");
        app.contacts().modifyContact(modifiedContact.getContactId(), contact);
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
        verifyContactsListInUi();
    }

    /*
        @Test
        public void checkContactEditing() {

        List<ContactData> before = app.contacts().list();
        int index = 0;
        ContactData contact = new ContactData().withContactId(before.get(index).getContactId()).withLastName("Rose").withFirstName("Axl  eqwrqwer 1");
        app.contacts().modifyContact(index, contact);
        List<ContactData> after = app.contacts().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getContactId(), c2.getContactId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);

    }
    */
}
