package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;


public class TestContactCreation extends TestBase {

    @Test //(enabled = false)
    public void checkContactCreation() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().createGroup();
            app.goTo().homePage();
        }
        app.contact().createNewContact();
        app.contact().fillContactForm(new ContactData("01 test", "01 fgdgfgfgf", " 01 teat"," 01bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489", 1), true);
        app.contact().submit();
    }

}
