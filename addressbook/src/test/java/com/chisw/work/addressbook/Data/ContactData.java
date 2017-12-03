package com.chisw.work.addressbook.Data;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {
    @Expose
    private String fName;
    private String mName;
    @Expose
    private String lName;
    private String fullName;
    private String nick;
    private String title;
    private String company;
    @Expose
    private String address;
    @Expose
    private String homePhone;
    @Expose
    private String mobPhone;
    @Expose
    private String workPhone;
    private String allPhones;
    @Expose
    private String email;
    @Expose
    private String email2;
    @Expose
    private String email3;
    private String allEmails;
    @XStreamOmitField
    private int indexGroup;
    @XStreamOmitField
    private int contactId = Integer.MAX_VALUE;
    private File photo;

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

    public int getIndexGroup() {
        return indexGroup;
    }

    public int getContactId() {
        return contactId;
    }

    public File getPhoto() {
        return photo;
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

    public ContactData withIndexGroup(int indexGroup) {
        this.indexGroup = indexGroup;
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
