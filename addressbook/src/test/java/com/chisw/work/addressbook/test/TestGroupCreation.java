package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().createNewGroup();
        GroupData group = new GroupData("test123", "erwrqwer213123123", "hjsdhasdf");
        app.getGroupsHelper().fillGroupForm(group);
        app.getGroupsHelper().submitGroupCreation();
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData g : after) {
            if(g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

}
