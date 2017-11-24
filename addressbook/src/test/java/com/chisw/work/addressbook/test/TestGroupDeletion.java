package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class TestGroupDeletion extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        app.goTo().groupPage();
        if (! app.groups().isGroupsCreated()) { //(app.groups().list().size() == 0)
            app.groups().createGroupInBeforeMethod();
        }
    }

    @Test
    public void checkGroupDeletion() {
        Set<GroupData> before = app.groups().all();
        GroupData deletedGroup = before.iterator().next();
        app.groups().delete(deletedGroup);
        Set<GroupData> after = app.groups().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }

}
