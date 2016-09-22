package com.onemedia.control;

import java.util.ArrayList;

/**
 * Created by PhamHai on 9/21/2016.
 */
public class ExportTag {

    public ExportTag(Tag tag, Customer customer) {
        setTag(tag);
        setCustomer(customer);
        proList = new ArrayList<Product>();
    }

    public boolean addProduct(Product product) {
        if (proList.contains(product)) return false;

        proList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        return proList.remove(product);
    }

    public double sumMoney() {
        double sum = 0.0d;
        for (Product p : proList) {
            sum += p.getSellPrice() * p.getQuantity() * p.getDiscount();
        }
        return sum * customer.getDiscount();
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((ExportTag)(obj)).getTag());
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    private Tag tag;
    private ArrayList<Product> proList;
    private Customer customer;
}
