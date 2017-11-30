package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestGroupCreation extends TestBase {

    @DataProvider
    public Iterator<Object[]> valigGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withGroupName("test 1").withGroupComment("header 1").withGroupLogo("footer 1")});
        list.add(new Object[] {new GroupData().withGroupName("test 2").withGroupComment("header 2").withGroupLogo("footer 2")});
        list.add(new Object[] {new GroupData().withGroupName("test 3").withGroupComment("header 3").withGroupLogo("footer 3")});
        return list.iterator();
    }


    @Test(dataProvider = "valigGroups")
    public void checkGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups  before = app.groups().all();
        app.groups().createNewGroup(group);
        assertThat(app.groups().count(),equalTo(before.size() + 1));
        Groups after = app.groups().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
