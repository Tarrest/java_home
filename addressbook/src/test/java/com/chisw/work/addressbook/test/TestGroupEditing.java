package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TestGroupEditing extends TestBase {


    @BeforeMethod
    public void checkPreconditions() {
        app.goTo().groupPage();
        if (! app.groups().isGroupsCreated()) {
            app.groups().createGroupInBeforeMethod();
        }
    }

    @Test
    public void checkGroupEditing() {
        List<GroupData> before = app.groups().getGroupsList();
        int index = before.size() - 1;
        GroupData group = new GroupData("test 2", "test 2.1", "test 2.2", before.get(index).getId());
        app.groups().modifyGroup(index, group);
        List<GroupData> after = app.groups().getGroupsList();
        Assert.assertEquals(before.size(), after.size());
        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
