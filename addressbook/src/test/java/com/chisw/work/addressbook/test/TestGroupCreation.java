package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.getGroupsHelper().goToGroupsPage();
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().createNewGroup();
        GroupData group = new GroupData("test000", "test000", null);
        app.getGroupsHelper().fillGroupForm(group);
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

}
