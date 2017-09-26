package com.chisw.work.addressbook.test;

import org.testng.annotations.Test;

public class TestContactDeletion extends TestBase {

    @Test
    public void checkContactDeletion() {
        if (! app.getContactHelper().isContactCreared()) {
            if (! app.getGroupsHelper().isGroupsCreated()) {
                app.getNavigationHelper().goToGroupsPage();
                app.getGroupsHelper().createGroup();
                app.getNavigationHelper().backHomePage();
            }
            app.getContactHelper().createContact();
            app.getNavigationHelper().backHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
    }

}
