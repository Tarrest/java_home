package com.chisw.work.addressbook;

import org.testng.annotations.Test;


public class TestContactCreation extends TestBase {

    @Test
    public void testContactCreation() {
        app.createNewContact();
        app.fillContactForm(new ContactData("eqwrqwer", "fgdgfgfgf", "teat","bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489"));
        app.submitContactForm();
        app.backHomePage();
    }

}
