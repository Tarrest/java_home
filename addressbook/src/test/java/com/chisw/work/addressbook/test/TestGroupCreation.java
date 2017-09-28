package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        app.group().create();
        GroupData group = new GroupData("test000", "test000",null);
        app.group().fillGroupForm(group);
        app.group().submitGroupCreation();
        app.goTo().groupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

}
