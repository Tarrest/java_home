package com.chisw.work.addressbook.Data;

public class GroupData {

    private String groupName;
    private String groupLogo;
    private String groupComment;

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", groupId=" + groupId +
                '}';
    }

    private int groupId = Integer.MAX_VALUE;;

    public int getId() {
        return groupId;
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

    public GroupData withId(int groupId) {
        this.groupId = groupId;
        return this;
    }
    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }
    public GroupData withGroupLogo(String groupLogo) {
        this.groupLogo = groupLogo;
        return this;
    }
    public GroupData withGroupComment(String groupComment) {
        this.groupComment = groupComment;
        return this;
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

}
