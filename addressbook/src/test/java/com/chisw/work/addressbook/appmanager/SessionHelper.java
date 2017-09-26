package com.chisw.work.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String logField, String passField) {
        type(By.name("user"), logField);
        type(By.name("pass"), passField);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
