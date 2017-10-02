package com.chisw.work.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestContactEditing extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        if (! app.contacts().isContactCreared()) {
            if (! app.groups().isGroupsCreated()) {
                app.goTo().groupPage();
                app.groups().createGroupInBeforeMethod();
                app.goTo().homePage();
            }
            app.contacts().createContactInBeforeMethod();
            app.goTo().homePage();
        }
    }

    @Test
    public void checkContactEditing() {
        app.contacts().modifyContact();
    }

}
