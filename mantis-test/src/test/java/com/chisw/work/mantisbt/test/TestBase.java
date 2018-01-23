package com.chisw.work.mantisbt.test;

import com.chisw.work.mantisbt.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

/*    protected final static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));*/
    protected final static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
