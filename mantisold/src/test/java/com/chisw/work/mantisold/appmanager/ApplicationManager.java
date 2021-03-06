package com.chisw.work.mantisold.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

    private final Properties properties;
    WebDriver driver;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe"); //папку с драйверами добавил в path
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseUrl"));
    }
    public void stop() {
        driver.quit();
    }
}
