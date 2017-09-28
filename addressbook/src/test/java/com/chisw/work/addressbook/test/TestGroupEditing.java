package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class TestGroupEditing extends TestBase {

    @Test
    public void checkGroupEditing() {
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupsHelper().isGroupsCreated()) {
            app.getGroupsHelper().createGroup();
            app.getNavigationHelper().goToGroupsPage();
        }
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().selectCreatedGroup(before.size() - 1);
        app.getGroupsHelper().editGroup();
        GroupData group = new GroupData("test 2", "test 2.1", "test 2.2", before.get(before.size() - 1).getId());
        app.getGroupsHelper().fillGroupForm(group);
        app.getGroupsHelper().updateGroup();
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(before.size(), after.size());

/*        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));*/

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
