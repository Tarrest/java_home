package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupsHelper().getGroupsCount();
        app.getGroupsHelper().createNewGroup();
        app.getGroupsHelper().fillGroupForm(new GroupData("test123", "erwrqwer213123123", "hjsdhasdf"));
        app.getGroupsHelper().submitGroupCreation();
        app.getNavigationHelper().goToGroupsPage();
        int after = app.getGroupsHelper().getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }

}
