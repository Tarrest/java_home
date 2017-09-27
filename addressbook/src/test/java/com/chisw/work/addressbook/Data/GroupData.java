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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    }

    @Override
    public int hashCode() {
        return groupName != null ? groupName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    public String getGroupComment() {
        return groupComment;
    }
}
