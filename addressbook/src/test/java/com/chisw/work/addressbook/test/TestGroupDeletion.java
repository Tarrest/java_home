package com.chisw.work.addressbook.test;

import org.testng.annotations.Test;

public class TestGroupDeletion extends TestBase {

    @Test
    public void checkGroupDeletion() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().goToGroupsPage();
        }
        app.getGroupsHelper().selectCreatedGroup();
        app.getGroupsHelper().deleteGroup();
    }

}
