package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Groups before = app.groups().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData  group = new GroupData().withGroupName("test 2").withId(modifiedGroup.getId());
        app.groups().modifyGroup(group);
        assertThat(app.groups().count(),equalTo(before.size()));
        Groups after = app.groups().all();
        assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withAdded(group)));
    }

}
