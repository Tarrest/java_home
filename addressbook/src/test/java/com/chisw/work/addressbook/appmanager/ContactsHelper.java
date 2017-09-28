package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends BaseHelper {

    public ContactsHelper(WebDriver driver) {
        super(driver);
    }

    public void createNewContact() {
        click(By.linkText("ADD_NEW"));
    }

    public void submitContactForm() {
        click(By.name("submit"));
    }

    public void submitUpdateContactForm() {
        click(By.name("update"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getfName());
        type(By.name("middlename"), contactData.getmName());
        type(By.name("lastname"), contactData.getlName());
        type(By.name("nickname"), contactData.getNick());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByIndex(contactData.getIndexGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void pressEditContact() {
        click(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]"));
    }

    public boolean isContactCreared() {
        return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]"));
    }

    public void createContact() {
        createNewContact();
        fillContactForm(new ContactData("eqwrqwer", "fgdgfgfgf", "teat","bvbvnbnvb", "nmvnnmvbn", "nuuuunu", "dfgdfgdfgdfg", "0123465489", 1), true);
        submitContactForm();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
