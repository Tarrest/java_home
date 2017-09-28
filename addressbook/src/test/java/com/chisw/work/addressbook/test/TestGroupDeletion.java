package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TestGroupDeletion extends TestBase {

    @Test
    public void checkGroupDeletion() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().goToGroupsPage();
        }
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().selectCreatedGroup(before.size() - 1);
        app.getGroupsHelper().deleteGroup();
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() - 1);
/*        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);*/

        before.remove(before.size() - 1);
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
