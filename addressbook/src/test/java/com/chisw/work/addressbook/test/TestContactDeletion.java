package com.chisw.work.addressbook.test;

import org.testng.annotations.Test;

public class TestContactDeletion extends TestBase {

    @Test
    public void checkContactDeletion() {
        if (! app.contact().isContactCreared()) {
            if (app.group().list().size() == 0) {
                app.goTo().groupPage();
                app.group().createGroup();
                app.goTo().homePage();
            }
            app.contact().createContact();
            app.goTo().homePage();
        }
        app.contact().selectContact();
        app.contact().deleteContact();
    }

}
