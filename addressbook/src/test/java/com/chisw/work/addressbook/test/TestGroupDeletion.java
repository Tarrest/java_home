package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Groups before = app.groups().all();
        GroupData deletedGroup = before.iterator().next();
        app.groups().delete(deletedGroup);
        assertThat(app.groups().count(),equalTo(before.size() - 1));
        Groups after = app.groups().all();
        assertThat(after, equalTo(before.withoutAdded(deletedGroup)));
    }

}
