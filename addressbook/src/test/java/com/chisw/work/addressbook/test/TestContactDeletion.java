package com.chisw.work.addressbook.test;

import org.testng.annotations.Test;

public class TestContactDeletion extends TestBase {

    @Test
    public void checkContactDeletion() {
        if (! app.contacts().isContactCreared()) {
            if (! app.groups().isGroupsCreated()) {
                app.goTo().groupPage();
                app.groups().createGroupInBeforeMethod();
                app.goTo().backHomePage();
            }
            app.contacts().createContact();
            app.goTo().backHomePage();
        }
        app.contacts().selectContact();
        app.contacts().deleteContact();
    }

}
