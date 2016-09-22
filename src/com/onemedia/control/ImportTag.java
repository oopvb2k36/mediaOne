package com.onemedia.control;

import java.util.ArrayList;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class ImportTag {

    public ImportTag(Tag tag) {
        setTag(tag);
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
        for (Product p :  proList) {
            sum += p.getCostPrice() * p.getQuantity();
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((ImportTag)(obj)).getTag());
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

    public Product[] getProList() {
        return (Product[]) proList.toArray();
    }

    private Tag tag;
    private ArrayList<Product> proList;
}
