package com.chisw.work.addressbook.Data;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "groups")
    private Set<ContactData> contacts = new HashSet<ContactData>();

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

    public Contacts getContacts() {
        return new Contacts(contacts);
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

        if (groupId != groupData.groupId) return false;
        if (groupName != null ? !groupName.equals(groupData.groupName) : groupData.groupName != null) return false;
        if (groupLogo != null ? !groupLogo.equals(groupData.groupLogo) : groupData.groupLogo != null) return false;
        return groupComment != null ? groupComment.equals(groupData.groupComment) : groupData.groupComment == null;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupLogo != null ? groupLogo.hashCode() : 0);
        result = 31 * result + (groupComment != null ? groupComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }

}
