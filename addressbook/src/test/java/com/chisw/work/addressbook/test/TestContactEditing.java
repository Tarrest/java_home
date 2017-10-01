package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

public class TestContactEditing extends TestBase {

    @Test
    public void checkContactEditing() {
        if (! app.contacts().isContactCreared()) {
            if (! app.groups().isGroupsCreated()) {
                app.goTo().groupPage();
                app.groups().createGroupInBeforeMethod();
                app.goTo().backHomePage();
            }
            app.contacts().createContact();
            app.goTo().backHomePage();
        }
        app.contacts().pressEditContact();
        app.contacts().fillContactForm(new ContactData("02 new name123", "02 new fdssd", "02 new 23","02 new c33", "02 wewwwe","02 new qaer", "02dfsfsdf dfssd fs 12 ","+2156348446", 1), false);
        app.contacts().submitUpdateContactForm();
    }

}
