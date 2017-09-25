package com.chisw.work.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void backHomePage() {
        click(By.linkText("HOME"));
    }

    public void createNewContact() {
        click(By.linkText("ADD_NEW"));
    }

    public void goToGroupsPage() {
        click(By.linkText("GROUPS"));
    }
}
