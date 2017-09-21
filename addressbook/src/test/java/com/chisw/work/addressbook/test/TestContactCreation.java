package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;


public class TestContactCreation extends TestBase {

    @Test
    public void checkContactCreation() {
        app.getNavigationHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData("eqwrqwer", "fgdgfgfgf", "teat","bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489"));
        app.getContactHelper().submitUpdateContactForm();
    }

}
