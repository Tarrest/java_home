package com.chisw.work.addressbook.Data;

public class GroupData {
    private final String groupName;
    private final String groupLogo;
    private final String groupComment;
    private final String groupId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (groupName != null ? !groupName.equals(groupData.groupName) : groupData.groupName != null) return false;
        return groupId != null ? groupId.equals(groupData.groupId) : groupData.groupId == null;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }

    public String getId() {
        return groupId;
    }

    public GroupData(String groupName, String groupLogo, String groupComment, String groupId) {
        this.groupName = groupName;
        this.groupLogo = groupLogo;
        this.groupComment = groupComment;
        this.groupId = groupId;
    }

    public GroupData(String groupName, String groupLogo, String groupComment) {
        this.groupName = groupName;
        this.groupLogo = groupLogo;
        this.groupComment = groupComment;
        this.groupId = null;
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
