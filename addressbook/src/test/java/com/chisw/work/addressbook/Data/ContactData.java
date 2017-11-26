package com.chisw.work.addressbook.Data;

public class ContactData {
    private String fName;
    private String mName;
    private String lName;
    private String nick;
    private String title;
    private String company;
    private String address;
    private String homePhone;
    private String mobPhone;
    private String workPhone;
    private int indexGroup;
    private int contactId = Integer.MAX_VALUE;


    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
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

    public int getIndexGroup() {
        return indexGroup;
    }

    public int getContactId() {
        return contactId;
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

    public ContactData withhMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withIndexGroup(int indexGroup) {
        this.indexGroup = indexGroup;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (contactId != that.contactId) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (mobPhone != null ? !mobPhone.equals(that.mobPhone) : that.mobPhone != null) return false;
        return workPhone != null ? workPhone.equals(that.workPhone) : that.workPhone == null;
    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobPhone != null ? mobPhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + contactId;
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobPhone='" + mobPhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", contactId=" + contactId +
                '}';
    }

}
