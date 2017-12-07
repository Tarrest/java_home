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
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.groups().createGroupInBeforeMethod();
        }
    }

    @Test
    public void checkGroupDeletion() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.groups().delete(deletedGroup);
        assertThat(app.groups().count(),equalTo(before.size() - 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withoutAdded(deletedGroup)));
        verifyGroupsListInUi();
    }

/*   @Test
    public void deleteAllGroups() {
       app.goTo().groupPage();
       app.groups().deleteAll();
   }*/
}
