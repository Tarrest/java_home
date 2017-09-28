package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

public class TestContactEditing extends TestBase {

    @Test
    public void checkContactEditing() {
        if (! app.getContactHelper().isContactCreared()) {
            if (! app.getGroupsHelper().isGroupsCreated()) {
                app.getGroupsHelper().goToGroupsPage();
                app.getGroupsHelper().createGroup();
                app.getNavigationHelper().backHomePage();
            }
            app.getContactHelper().createContact();
            app.getNavigationHelper().backHomePage();
        }
        app.getContactHelper().pressEditContact();
        app.getContactHelper().fillContactForm(new ContactData("02 new name123", "02 new fdssd", "02 new 23","02 new c33", "02 wewwwe","02 new qaer", "02dfsfsdf dfssd fs 12 ","+2156348446", 1), false);
        app.getContactHelper().submitUpdateContactForm();
    }

}
