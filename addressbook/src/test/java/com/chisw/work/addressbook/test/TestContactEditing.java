package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import org.testng.annotations.Test;

public class TestContactEditing extends TestBase {

    @Test
    public void checkContactEditing() {
        if (! app.contact().isContactCreared()) {
            if (app.group().list().size() == 0) {
                app.goTo().groupPage();
                app.group().createGroup();
                app.goTo().homePage();
            }
            app.contact().createContact();
            app.goTo().homePage();
        }
        app.contact().edit();
        app.contact().fillContactForm(new ContactData("02 new name123", "02 new fdssd", "02 new 23","02 new c33", "02 wewwwe","02 new qaer", "02dfsfsdf dfssd fs 12 ","+2156348446", 1), false);
        app.contact().update();
    }

}
