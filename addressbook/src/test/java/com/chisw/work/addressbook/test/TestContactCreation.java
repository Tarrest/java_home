package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestContactCreation extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new ContactData().withFirstName(split[0]).withLastName(split[1]).withAddress(split[2]).withEmail(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @BeforeMethod
    public void checkPreconditions() {
        app.goTo().groupPage();
        if (! app.groups().isGroupsCreated()) {
            app.groups().createGroupInBeforeMethod();
        }
    }


    @Test(dataProvider = "validContacts")
    public void checkContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contacts().all();
        //File photo = new File("src/test/resources/image.jpg");
        //System.out.println(photo.exists());
        //ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Petrov").withPhoto(photo);
        assertThat(app.contacts().count(),equalTo(before.size() + 1));
        app.contacts().createContact(contact);
        Contacts after = app.contacts().all();
        assertThat(after, equalTo(before.withAdded(contact.withContactId(after.stream().mapToInt((c) -> c.getContactId()).max().getAsInt()))));
        }

    /*
    @Test(dataProvider = "validGroups")
    public void checkGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups  before = app.groups().all();
        app.groups().createNewGroup(group);
        assertThat(app.groups().count(),equalTo(before.size() + 1));
        Groups after = app.groups().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }*/
}
