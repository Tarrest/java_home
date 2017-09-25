package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

public class TestContactEdit extends TestBase {

    @Test
    public void checkContactEdit() {
        app.getContactHelper().pressEditContact();
        app.getContactHelper().fillContactForm(new ContactData("new name123", "new fdssd", "new 23","new c33", "wewwwe","new qaer", "dfsfsdf dfssd fs 12 ","+2156348446", null), false);
        app.getContactHelper().submitUpdateContactForm();
    }

}
