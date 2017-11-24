package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactsHelper extends BaseHelper {

    public ContactsHelper(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewContact() {
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

    public void clickDeleteContact() {
        click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
    }

    public void pressEditContact() {
        click(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]"));
    }

    public boolean isContactCreared() {
        return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]"));
    }

    public void selectContact(int index) {
        List<WebElement> contactList = driver.findElements(By.name("selected[]"));
        contactList.get(index).click();
    }

    private void selectContactById(int contactId) {
        driver.findElement(By.cssSelector("input[value='" + contactId + "']")).click();
    }

    public void reloadPage() {
        click(By.linkText("HOME"));
    }

    public void createContactInBeforeMethod() {
        clickCreateNewContact();
        fillContactForm(new ContactData().withFirstName("Pedro").withLastName("Kortez").withIndexGroup(1), true);
        submitContactForm();
        reloadPage();
    }


    public void modifyContact(int index, ContactData contact) {
        selectContact(index);
        pressEditContact();
        fillContactForm(contact, false);
        submitUpdateContactForm();
        reloadPage();
    }


    public void modifyContact(ContactData contact) {
        selectContactById(contact.getContactId());
        pressEditContact();
        fillContactForm(contact, false);
        submitUpdateContactForm();
        reloadPage();
    }

    public void deleteContact(ContactData deletedContact) {
        selectContactById(deletedContact.getContactId());
        clickDeleteContact();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        reloadPage();
    }

    public void createContact(ContactData contact) {
        clickCreateNewContact();
        fillContactForm(contact, true);
        submitContactForm();
        reloadPage();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData().withContactId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData().withContactId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

}
