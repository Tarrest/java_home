package com.chisw.work.addressbook.appmanager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ApplicationManager {

    private final Properties properties;
    WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactsHelper contactsHelper;
    private GroupsHelper groupsHelper;
    private String browser;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        if ("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe"); //папку с драйверами добавил в path
                driver = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
                driver = new ChromeDriver();
            }
        } else {
 //           DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setBrowserName(browser);
//            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win10")));

            String[] chromeOptions = {"--headless", "--disable-gpu"};

            ChromeOptions options = new ChromeOptions();
            options.addArguments(chromeOptions);
            options.setCapability("platformName", System.getProperty("platform", "win10"));


            driver = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), options);



        }
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);






        driver.get(properties.getProperty("web.baseUrl"));
        contactsHelper = new ContactsHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        groupsHelper = new GroupsHelper(driver);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void stop() {
        driver.quit();
    }

    public ContactsHelper contacts() {
        return contactsHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public GroupsHelper groups() {
        return groupsHelper;
    }

    public DbHelper db() {
        return dbHelper;
    }
}
