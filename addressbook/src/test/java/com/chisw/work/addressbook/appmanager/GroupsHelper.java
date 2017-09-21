package com.chisw.work.addressbook.appmanager;

import com.chisw.work.addressbook.Data.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void selectCreatedGroup() {
        click(By.xpath(".//*[@id='content']/form/span[1]/input"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }


}
