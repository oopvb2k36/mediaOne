package com.onemedia.control;

/**
 * Created by PhamHai on 9/20/2016.
 */
public abstract class Product {

    public Product(Tag tag, String name) {
        this.type = ProductType.UNKNOWN;
        setTag(tag);
        setName(name);
        setQuantity(0);
        setCostPrice(0.0d);
        setSellPrice(0.0d);
        setDiscount(0.0d);
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((Product)obj).getTag());
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

    public void setQuantity(int quantity) {
        if (quantity < 0) this.quantity = 0;
        else this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCostPrice(double costPrice) {
        if (costPrice < 0) this.costPrice = 0;
        else this.costPrice = costPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setSellPrice(double sellPrice) {
        if (sellPrice < 0) this.sellPrice = 0;
        else this.sellPrice = sellPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setDiscount(double discount) {
        if (discount < 0) this.discount = 0;
        else this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public ProductType getType() {
        return type;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    protected Tag tag;
    protected String name;
    protected int quantity;
    protected double costPrice;
    protected double sellPrice;
    protected double discount;
    protected ProductType type;
    protected Provider provider;
}
