package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.groups().list();
        GroupData group = new GroupData().withGroupName("test123").withGroupLogo("yert1234").withGroupComment("gfsh567");
        app.groups().createNewGroup(group);
        List<GroupData> after = app.groups().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
