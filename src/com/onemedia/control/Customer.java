package com.onemedia.control;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Customer {

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((Customer)(obj)).getTag());
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDiscount(double discount) {
        if (discount < 0 ) this.discount = discount;
        else this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    private Tag tag;
    private String name;
    private String address;
    private double discount;
}
