package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;


public class TestContactCreation extends TestBase {

    @Test (enabled = false)
    public void checkContactCreation() {
        app.getGroupsHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().backHomePage();
        }
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData("01 test", "01 fgdgfgfgf", " 01 teat"," 01bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489", 1), true);
        app.getContactHelper().submitContactForm();
    }

}
