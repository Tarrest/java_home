package com.chisw.work.addressbook.Data;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int contactId = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String fName;
    @Transient
    private String mName;
    @Expose
    @Column(name = "lastname")
    private String lName;
    @Transient
    private String fullName;
    @Transient
    private String nick;
    @Transient
    private String title;
    @Transient
    private String company;
    @Expose
    @Transient
    private String address;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobPhone;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Transient
    private String allPhones;
    @Expose
    @Transient
    private String email;
    @Expose
    @Transient
    private String email2;
    @Expose
    @Transient
    private String email3;
    @Transient
    private String allEmails;
    @Transient
    private File photo;
    @ManyToMany
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public ContactData(Set<ContactData> contacts) {
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNick() {
        return nick;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public int getContactId() {
        return contactId;
    }

    public File getPhoto() {
        return photo;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withContactId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public ContactData withFirstName(String fName) {
        this.fName = fName;
        return this;
    }

    public ContactData withMiddleName(String mName) {
        this.mName = mName;
        return this;
    }

    public ContactData withLastName(String lName) {
        this.lName = lName;
        return this;
    }

    public ContactData withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public ContactData withNick(String nick) {
        this.nick = nick;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (contactId != that.contactId) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        return lName != null ? lName.equals(that.lName) : that.lName == null;
    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + contactId;
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", contactId=" + contactId +
                '}';
    }

}
