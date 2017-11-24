package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupsHelper extends BaseHelper{

    public GroupsHelper(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewGroup() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupLogo());
        type(By.name("group_footer"), groupData.getGroupComment());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void selectCreatedGroup(int index) {
        List<WebElement> groupsList = driver.findElements(By.name("selected[]"));
        groupsList.get(index).click();
    }

    public void selectCreatedGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void reloadGroupPage() {
        click(By.linkText("GROUPS"));
    }

    public void clickDeleteGroup() {
        click(By.name("delete"));
    }

    public void editGroup() {
        click(By.name("edit"));
    }

    public void updateGroup() {
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
        reloadGroupPage();
    }

    public void modifyGroup(GroupData group) {
        selectCreatedGroupById(group.getId());
        editGroup();
        fillGroupForm(group);
        updateGroup();
        reloadGroupPage();
    }

    public void delete(int index) {
        selectCreatedGroup(index);
        clickDeleteGroup();
        reloadGroupPage();
    }

    public void delete(GroupData deletedGroup) {
        selectCreatedGroupById(deletedGroup.getId());
        clickDeleteGroup();
        reloadGroupPage();
    }

    public boolean isGroupsCreated() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<GroupData> list() { //возвращаем список
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int groupId = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withGroupName(name).withId(groupId);
            groups.add(group);
        }
        return groups;
    }

    public Set<GroupData> all() { //возвращаем множество
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int groupId = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withGroupName(name).withId(groupId);
            groups.add(group);
        }
        return groups;
    }


}
