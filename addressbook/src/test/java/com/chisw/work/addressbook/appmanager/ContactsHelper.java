package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.ContactData;
import com.chisw.work.addressbook.Data.Contacts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    public int count() {
        return  Integer.parseInt(driver.findElement(By.xpath(".//*[@id='search_count']")).getText());
    }

    private void selectContactById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void modifyContact(ContactData contact) {
        selectContactById(contact.getContactId());
        pressEditContact();
        fillContactForm(contact, false);
        submitUpdateContactForm();
        contactCashe = null;
        reloadPage();
    }

    public void deleteContact(ContactData deletedContact) {
        selectContactById(deletedContact.getContactId());
        clickDeleteContact();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        contactCashe = null;
        reloadPage();
    }

    public void createContact(ContactData contact) {
        clickCreateNewContact();
        fillContactForm(contact, true);
        submitContactForm();
        contactCashe = null;
        reloadPage();
    }

    private Contacts contactCashe = null;

    public Contacts all() {

        if (contactCashe != null) {
            return new Contacts(contactCashe);
        }

        contactCashe = new Contacts();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            ContactData contact = new ContactData().withContactId(id).withFirstName(firstName).withLastName(lastName);
            contactCashe.add(contact);
        }
        return new Contacts(contactCashe);
    }

    public Set<ContactData> allForPhone() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contacts.add(new ContactData().withContactId(id).withFirstName(firstName).withLastName(lastName)
                            .withAllPhones(allPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
      initContactModificationById(contact.getContactId());
      String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
      String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
      String homePhone = driver.findElement(By.name("home")).getAttribute("value");
      String workPhone = driver.findElement(By.name("work")).getAttribute("value");
      String mobPhone = driver.findElement(By.name("mobile")).getAttribute("value");
      driver.navigate().back();
      return new ContactData().withContactId(contact.getContactId()).withFirstName(firstName)
              .withLastName(lastName).withHomePhone(homePhone)
              .withMobPhone(mobPhone).withWorkPhone(workPhone);
    }

    private void initContactModificationById(int id) {
        driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }
}
