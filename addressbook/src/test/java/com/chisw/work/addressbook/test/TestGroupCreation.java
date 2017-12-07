package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestGroupCreation extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); //List<GroupData>.class
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test(dataProvider = "validGroupsFromJson")
    public void checkGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.db().groups();
        app.groups().createNewGroup(group);
        assertThat(app.groups().count(),equalTo(before.size() + 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyGroupsListInUi();
    }
}
