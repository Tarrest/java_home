package com.chisw.work.addressbook.Data;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int groupId = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private String groupName;
    @Expose
    @Column(name = "group_header")
    @Type(type = "text")
    private String groupLogo;
    @Expose
    @Type(type = "text")
    @Column(name = "group_footer")
        private String groupComment;

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
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (groupId != groupData.groupId) return false;
        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + groupId;
        return result;
    }

}
