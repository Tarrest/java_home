package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().createNewGroup();
        app.getGroupsHelper().fillGroupForm(new GroupData("test123", "erwrqwer213123123", "hjsdhasdf"));
        app.getGroupsHelper().submitGroupCreation();
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
