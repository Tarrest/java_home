package com.chisw.work.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactsHelper contactsHelper;
    private GroupsHelper groupsHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe"); //папку с драйверами добавил в path
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        contactsHelper = new ContactsHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        groupsHelper = new GroupsHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public ContactsHelper contacts() {
        return contactsHelper;
    }

    public NavigationHelper navigation() {
        return navigationHelper;
    }

    public GroupsHelper groups() {
        return groupsHelper;
    }
}
