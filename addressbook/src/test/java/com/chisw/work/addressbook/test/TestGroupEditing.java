package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Set<GroupData> before = app.groups().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData  group = new GroupData().withGroupName("test 2").withId(modifiedGroup.getId());
        app.groups().modifyGroup(group);
        Set<GroupData> after = app.groups().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
