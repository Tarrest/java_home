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

    private void clickCreateNewContact() {
        click(By.linkText("ADD_NEW"));
    }

    private void submitContactForm() {
        click(By.name("submit"));
    }

    private void submitUpdateContactForm() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getfName());
        type(By.name("middlename"), contactData.getmName());
        type(By.name("lastname"), contactData.getlName());
        type(By.name("nickname"), contactData.getNick());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobPhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByIndex(contactData.getIndexGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    private void clickDeleteContact() {
        click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
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

    private void reloadPage() {
        click(By.linkText("HOME"));
    }

    public void createContactInBeforeMethod() {
        clickCreateNewContact();
        fillContactForm(new ContactData().withFirstName("Pedro").withLastName("Kortez").withIndexGroup(1), true);
        submitContactForm();
        reloadPage();
    }

    public void modifyContact(int id, ContactData contact) {
        initContactModificationById(id);
        fillContactForm(contact, false);
        submitUpdateContactForm();
        contactCache = null;
        reloadPage();
    }

    public void deleteContact(ContactData deletedContact) {
        selectContactById(deletedContact.getContactId());
        clickDeleteContact();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        contactCache = null;
        reloadPage();
    }

    public void createContact(ContactData contact) {
        clickCreateNewContact();
        fillContactForm(contact, true);
        submitContactForm();
        contactCache = null;
        reloadPage();
    }

    private Contacts contactCache = null;

    public Contacts all() {

        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            ContactData contact = new ContactData().withContactId(id).withFirstName(firstName).withLastName(lastName).withAddress(address);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public Set<ContactData> allFromHomePage() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            contacts.add(new ContactData().withContactId(id).withFirstName(firstName).withLastName(lastName)
                    .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
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
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withContactId(contact.getContactId()).withFirstName(firstName)
                .withLastName(lastName).withHomePhone(homePhone)
                .withMobPhone(mobPhone).withWorkPhone(workPhone)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    private void initContactModificationById(int id) {
        //driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
        driver.findElement(By.xpath(".//a[@href=\"edit.php?id=" + id + "\"]/img")).click();
    }

    public ContactData infoFromDetails(ContactData contact) {
        initDetailsById(contact.getContactId());
        String fullName = driver.findElement(By.xpath(".//*[@id='content']/b")).getText();
        String email = driver.findElement(By.xpath(".//*[@id='content']/a[1]")).getText();
        String email2 = driver.findElement(By.xpath(".//*[@id='content']/a[2]")).getText();
        String email3 = driver.findElement(By.xpath(".//*[@id='content']/a[3]")).getText();
        //String address = driver.findElement(By.linkText(contact.getAddress())).getText();
        driver.navigate().back();
        return new ContactData().withFullName(fullName).withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    private void initDetailsById(int id) {
        driver.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }
}
