package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class GroupsHelper extends BaseHelper{

    public GroupsHelper(WebDriver driver) {
        super(driver);
    }

    private void clickCreateNewGroup() {
        click(By.name("new"));
    }

    private void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupLogo());
        type(By.name("group_footer"), groupData.getGroupComment());
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void selectCreatedGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    private void reloadGroupPage() {
        click(By.linkText("GROUPS"));
    }

    private void clickDeleteGroup() {
        click(By.name("delete"));
    }

    private void editGroup() {
        click(By.name("edit"));
    }

    private void updateGroup() {
        click(By.name("update"));
    }


    public void createGroupInBeforeMethod() {
        clickCreateNewGroup();
        fillGroupForm(new GroupData().withGroupName("test1").withGroupLogo("test2").withGroupName("test3"));
        submitGroupCreation();
        reloadGroupPage();
    }

    public void createNewGroup(GroupData group) {
        clickCreateNewGroup();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        reloadGroupPage();
    }

    public void modifyGroup(GroupData group) {
        selectCreatedGroupById(group.getId());
        editGroup();
        fillGroupForm(group);
        updateGroup();
        groupCache = null;
        reloadGroupPage();
    }

    public void delete(GroupData deletedGroup) {
        selectCreatedGroupById(deletedGroup.getId());
        clickDeleteGroup();
        groupCache = null;
        reloadGroupPage();
    }

    public boolean isGroupsCreated() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count(){
        return driver.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int groupId = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withGroupName(name).withId(groupId);
            groupCache.add(group);
        }
        return new Groups(groupCache);
    }


    public void deleteAll() {
        List <WebElement> elements = driver.findElements(By.name("selected[]"));
        for (WebElement el : elements) {
            el.click();
        }
        clickDeleteGroup();
    }
}
