package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupsHelper extends BaseHelper{

    public GroupsHelper(WebDriver driver) {
        super(driver);
    }

    public void createNewGroup() {
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

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void editGroup() {
        click(By.name("edit"));
    }

    public void updateGroup() {
        click(By.name("update"));
    }


    public void createGroup() {
        createNewGroup();
        fillGroupForm(new GroupData("test1", null, null));
        submitGroupCreation();

    }

    public boolean isGroupsCreated() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupsCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupsList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int groupId = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(name, null, null, groupId);
            groups.add(group);
        }
        return groups;
    }
}
