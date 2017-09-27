package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestGroupEditing extends TestBase {

    @Test
    public void checkGroupEditing() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().goToGroupsPage();
        }
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().selectCreatedGroup(before.size() - 1);
        app.getGroupsHelper().editGroup();
        app.getGroupsHelper().fillGroupForm(new GroupData("edit name2", null, null));
        app.getGroupsHelper().updateGroup();
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(before.size(), after.size());
    }
}
