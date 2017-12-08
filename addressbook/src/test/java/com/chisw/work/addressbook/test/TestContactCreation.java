package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
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
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestContactCreation extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }


    @BeforeMethod
    public void checkPreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.groups().createGroupInBeforeMethod();
        }
    }

/*      File photo = new File("src/test/resources/image.jpg");
        System.out.println(photo.exists());
        ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Petrov").withPhoto(photo);
*/

    @Test(dataProvider = "validContactsFromJson")
    public void checkGroupCreation(ContactData contact, Groups group) {
        Groups groups = app.db().groups();
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contacts().createContact(contact.inGroup(group.iterator().next())); //переделать
        assertThat(app.contacts().count(),equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(
                before.withAdded(contact.withContactId(after.stream().mapToInt((c) -> c.getContactId()).max().getAsInt()))));
        verifyContactsListInUi();
    }

}
