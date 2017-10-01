package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;


public class TestContactCreation extends TestBase {

    @Test
    public void checkContactCreation() {
        app.goTo().groupPage();
        if (! app.groups().isGroupsCreated()) {
            app.groups().createGroupInBeforeMethod();
            app.goTo().backHomePage();
        }
        app.contacts().createNewContact();
        app.contacts().fillContactForm(new ContactData("01 test", "01 fgdgfgfgf", " 01 teat"," 01bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489", 1), true);
        app.contacts().submitContactForm();
    }

}
