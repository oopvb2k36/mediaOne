package com.onemedia.control;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Payment {

    public Payment(Tag tag, String name, double money) {
        setTag(tag);
        setName(name);
        setMoney(money);
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((Payment)(obj)).getTag());
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

    public void setMoney(double money) {
        if (money < 0) this.money = 0;
        else this.money = money;
    }

    public double getMoney() {
        return money;
    }

    private Tag tag;
    private String name;
    private double money;
}
