package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.goTo().groupPage();
        Set<GroupData> before = app.groups().all();
        GroupData group = new GroupData().withGroupName("test123").withGroupLogo("yert1234").withGroupComment("gfsh567");
        app.groups().createNewGroup(group);
        Set<GroupData> after = app.groups().all();
        Assert.assertEquals(after.size(),before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
