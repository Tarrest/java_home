package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import com.chisw.work.addressbook.appmanager.ApplicationManager;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@Listeners(MyTestListener.class)
public class TestBase {

    protected final static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
    //protected final static ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
        }

    public void verifyGroupsListInUi() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.groups().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withGroupName(g.getGroupName()))
                    .collect(Collectors.toSet())));
        }
    }

    public void verifyContactsListInUi() {
        if (Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contacts().all();
            assertThat(uiContacts, equalTo(dbContacts.stream()
                    .map((c) -> new ContactData().withContactId(c.getContactId()).withLastName(c.getlName())
                            .withFirstName(c.getfName()).withAddress(c.getAddress()))
                            .collect(Collectors.toSet())));
        }
    }

}
