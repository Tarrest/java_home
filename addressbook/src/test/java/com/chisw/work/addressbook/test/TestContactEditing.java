package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

public class TestContactEditing extends TestBase {

    @Test
    public void checkContactEditing() {
        if (! app.getContactHelper().isContactCreared()) {
            if (! app.getGroupsHelper().isGroupsCreated()) {
                app.getNavigationHelper().goToGroupsPage();
                app.getGroupsHelper().createGroup();
                app.getNavigationHelper().backHomePage();
            }
            app.getContactHelper().createContact();
            app.getNavigationHelper().backHomePage();
        }
        app.getContactHelper().pressEditContact();
        app.getContactHelper().fillContactForm(new ContactData("new name123", "new fdssd", "new 23","new c33", "wewwwe","new qaer", "dfsfsdf dfssd fs 12 ","+2156348446", 1), false);
        app.getContactHelper().submitUpdateContactForm();
    }

}
