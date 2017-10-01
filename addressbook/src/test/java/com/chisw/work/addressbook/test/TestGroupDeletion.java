package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TestGroupDeletion extends TestBase {

    @BeforeMethod
    public void checkPreconditions() {
        app.groups().goToGroupsPage();
        if (! app.groups().isGroupsCreated()) {
            app.groups().createGroup();
            app.groups().goToGroupsPage();
        }
    }

    @Test
    public void checkGroupDeletion() {
        List<GroupData> before = app.groups().getGroupsList();
        int index = before.size() - 1;
        app.groups().selectCreatedGroup(index);
        app.groups().deleteGroup();
        app.groups().goToGroupsPage();
        List<GroupData> after = app.groups().getGroupsList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
