package com.chisw.work.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.open();
    }

    @AfterMethod
    public void tearDown() {
        app.close();
    }

}
