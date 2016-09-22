package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public class Store implements ISystemManagement, IStaffManagement {

    public Store(Tag tag, String name) {
        setTag(tag);
        setName(name);
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((Store)(obj)).getTag());
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public Staff getLoggedStaff() {
        return loggedStaff;
    }

    private Tag tag;
    private String name;
    private String director;
    private String phone;
    private String website;
    private String address;
    private String taxCode;
    private Staff loggedStaff;

    @Override
    public Staff logIn(String code, String pass) {
        return null;
    }

    @Override
    public Staff logOut() {
        return null;
    }

    @Override
    public boolean saveStaffInfo(Staff staff) {
        return false;
    }

    @Override
    public Staff[] getStaffList() {
        return new Staff[0];
    }

    @Override
    public Staff getStaffByTagCode(String tagCode) {
        return null;
    }
}
