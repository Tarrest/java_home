package com.chisw.work.addressbook.test;

import org.testng.annotations.Test;

public class TestContactDeletion extends TestBase {

    @Test
    public void checkContactDeletion() {
        if (! app.contacts().isContactCreared()) {
            if (! app.groups().isGroupsCreated()) {
                app.groups().goToGroupsPage();
                app.groups().createGroup();
                app.navigation().backHomePage();
            }
            app.contacts().createContact();
            app.navigation().backHomePage();
        }
        app.contacts().selectContact();
        app.contacts().deleteContact();
    }

}
