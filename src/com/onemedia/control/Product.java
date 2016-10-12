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
        // TODO: bổ sung tính giá bán
        return 0;
    }

    public double getCostPrice() {
        // TODO: bổ sung tính giá mua
        return 0;
    }

    public void printInfo() {
        // TODO: bổ sung in thông tin ra màn hình
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
