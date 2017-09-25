package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;


public class TestContactCreation extends TestBase {

    @Test
    public void checkContactCreation() {
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData("eqwrqwer", "fgdgfgfgf", "teat","bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489", "edit name1"), true);
        app.getContactHelper().submitContactForm();
    }

}
