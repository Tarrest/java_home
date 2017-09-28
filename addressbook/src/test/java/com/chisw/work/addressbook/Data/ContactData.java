package com.chisw.work.addressbook.Data;

public class ContactData {
    private final String fName;
    private final String mName;
    private final String lName;
    private final String nick;
    private final String title;
    private final String company;
    private final String address;
    private final String homePhone;
    private final int indexGroup;
    private int contactId;

    public ContactData(String fName, String mName, String lName, String nick, String title, String company, String address, String homePhone, int indexGroup, int contactId) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.nick = nick;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.indexGroup = indexGroup;
        this.contactId = contactId;
    }

    public ContactData(String fName, String mName, String lName, String nick, String title, String company, String address, String homePhone, int indexGroup) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.nick = nick;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.indexGroup = indexGroup;
        this.contactId = 0;
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

    public int getIndexGroup() {
        return indexGroup;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", contactId=" + contactId +
                '}';
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

}
