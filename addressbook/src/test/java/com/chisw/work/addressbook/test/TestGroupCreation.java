package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestGroupCreation extends TestBase {

    @DataProvider
    public Iterator<Object[]> valigGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new GroupData().withGroupName(split[0]).withGroupComment(split[1]).withGroupLogo(split[2])});
            line = reader.readLine();
        }
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
