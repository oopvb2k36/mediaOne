package com.onemedia.control;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Staff {

    public Staff(Tag tag, String name) {
        setTag(tag);
        setName(name);
        pass = null;
        groups = 0;
        status = StaffStatus.DISABLED;
        salary = 0.0d;
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((Staff)(obj)).getTag());
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }

    public int getGroups() {
        return groups;
    }

    public void setStatus(StaffStatus status) {
        this.status = status;
    }

    public StaffStatus getStatus() {
        return status;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    private Tag tag;
    private String name;
    private String pass;
    private int groups;
    private StaffStatus status;
    private double salary;
}
