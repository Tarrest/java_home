package com.chisw.work.addressbook.Data;

public class GroupData {
    private final String groupName;
    private final String groupLogo;
    private final String groupComment;

    public GroupData(String groupName, String groupLogo, String groupComment) {
        this.groupName = groupName;
        this.groupLogo = groupLogo;
        this.groupComment = groupComment;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupLogo() {
        return groupLogo;
    }

    public String getGroupComment() {
        return groupComment;
    }
}
