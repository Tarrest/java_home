package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.groups().goToGroupsPage();
        List<GroupData> before = app.groups().getGroupsList();
        app.groups().createNewGroup();
        GroupData group = new GroupData("test000", "test000", null);
        app.groups().fillGroupForm(group);
        app.groups().submitGroupCreation();
        app.groups().goToGroupsPage();
        List<GroupData> after = app.groups().getGroupsList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}
