package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGroupModification extends TestBase {


    @BeforeMethod
    public void checkPreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.groups().createGroupInBeforeMethod();
        }
    }

    @Test
    public void checkGroupModification() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData  group = new GroupData()
                .withId(modifiedGroup.getId()).withGroupName("test 258").withGroupLogo("Logo 123").withGroupComment("Comment 12345");
        app.goTo().groupPage();
        app.groups().modifyGroup(group);
        assertThat(app.groups().count(),equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withAdded(group)));
        verifyGroupsListInUi();
    }

}
