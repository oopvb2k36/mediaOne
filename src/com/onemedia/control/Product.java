package com.onemedia.control;

public abstract class Product {

    public Product() {
        idCode = "-1";
        name = "NO NAME";
        quantity = 0;
        costUnitPrice = 0;
        sellUnitPrice = 0;
    }

    public Product(String idCode, String name) {
        setIdCode(idCode);
        setName(name);
        quantity = 0;
        costUnitPrice = 0;
        sellUnitPrice = 0;
    }

    public Product(Product product) {
        setIdCode(product.getIdCode());
        setName(product.getName());
        setQuantity(product.getQuantity());
        setCostUnitPrice(product.getCostUnitPrice());
        setSellUnitPrice(product.getSellUnitPrice());
        setDiscount(product.getDiscount());
    }

    public double getSellPrice() {
        if(quantity!=0){
            quantity*sellUnitPrice;
        }
        else
        return 0;
    }

    public double getCostPrice() {
        if(quantity!=0){
            quantity*costUnitPrice;
        }else
        return 0;
    }

    public void printInfo() {
        System.out.format("Ma SP: %s, Ten SP: %s, So luong: %s, Chiet khau: %s\n",
                idCode, name, quantity, discount);
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getIdCode() {
        return idCode;
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

    public void setCostUnitPrice(double costUnitPrice) {
        if (costUnitPrice < 0) this.costUnitPrice = 0;
        else this.costUnitPrice = costUnitPrice;
    }

    public double getCostUnitPrice() {
        return costUnitPrice;
    }

    public void setSellUnitPrice(double sellUnitPrice) {
        if (sellUnitPrice < 0) this.sellUnitPrice = 0;
        else this.sellUnitPrice = sellUnitPrice;
    }

    public double getSellUnitPrice() {
        return sellUnitPrice;
    }

    public void setDiscount(double discount) {
        if (discount < 0) this.discount = 0;
        else this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    private String idCode;
    private String name;
    private int quantity;
    private double costUnitPrice;
    private double sellUnitPrice;
    private double discount;
}
