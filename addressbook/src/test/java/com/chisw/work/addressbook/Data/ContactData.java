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

    public ContactData(String fName, String mName, String lName, String nick, String title, String company, String address, String homePhone, int  indexGroup) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.nick = nick;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.indexGroup = indexGroup;
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
}
