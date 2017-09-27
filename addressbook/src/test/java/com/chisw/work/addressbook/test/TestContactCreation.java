package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

import java.util.List;


public class TestContactCreation extends TestBase {

    @Test
    public void checkContactCreation() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().backHomePage();
        }
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData("eqwrqwer", "fgdgfgfgf", "teat","bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489", 1), true);
        app.getContactHelper().submitContactForm();
    }

}
