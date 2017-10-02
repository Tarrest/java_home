package com.chisw.work.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestContactDeletion extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        if (! app.contacts().isContactCreared()) {
            app.goTo().groupPage();
            if (! app.groups().isGroupsCreated()) {
                app.groups().createGroupInBeforeMethod();
                app.goTo().homePage();
            }
            app.contacts().createContactInBeforeMethod();
            app.goTo().homePage();
        }
    }


    @Test
    public void checkContactDeletion() {
        app.contacts().selectContact();
        app.contacts().deleteContact();
    }

}
