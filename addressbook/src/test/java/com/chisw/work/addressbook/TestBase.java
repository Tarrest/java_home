package com.chisw.work.addressbook;

import appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase extends ApplicationManager{

    protected ApplicationManager app = new ApplicationManager();

    @BeforeTest
    public void startDriver() {
        app.init();
    }

    @AfterTest
    public void tearDownDriver() {
        app.stop();
    }

}
