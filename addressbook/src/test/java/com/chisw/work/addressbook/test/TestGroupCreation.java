package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestGroupCreation extends TestBase {

    @Test
    public void checkGroupCreation() {
        app.goTo().groupPage();
        Groups  before = app.groups().all();
        GroupData group = new GroupData().withGroupName("test123");
        app.groups().createNewGroup(group);
        Groups after = app.groups().all();
        assertThat(after.size(),equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
