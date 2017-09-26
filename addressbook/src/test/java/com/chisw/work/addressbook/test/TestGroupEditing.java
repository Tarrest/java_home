package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.annotations.Test;

public class TestGroupEditing extends TestBase {

    @Test
    public void checkGroupEditing() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().goToGroupsPage();
        }
        app.getGroupsHelper().selectCreatedGroup();
        app.getGroupsHelper().editGroup();
        app.getGroupsHelper().fillGroupForm(new GroupData("edit name1", null, null));
        app.getGroupsHelper().updateGroup();
        app.getNavigationHelper().goToGroupsPage();
    }
}
