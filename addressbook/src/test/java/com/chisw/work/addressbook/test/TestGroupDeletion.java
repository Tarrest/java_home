package com.chisw.work.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGroupDeletion extends TestBase {

    @Test
    public void checkGroupDeletion() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().goToGroupsPage();
        }
        int before = app.getGroupsHelper().getGroupsCount();
        app.getGroupsHelper().selectCreatedGroup();
        app.getGroupsHelper().deleteGroup();
        app.getNavigationHelper().goToGroupsPage();
        int after = app.getGroupsHelper().getGroupsCount();
        Assert.assertEquals(after, before - 1);
    }

}
