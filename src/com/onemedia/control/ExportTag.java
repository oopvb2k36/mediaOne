package com.onemedia.control;

import java.util.ArrayList;
import java.util.Date;

public class ExportTag {

    public ExportTag(String idCode) {
        setIdCode(idCode);
        timeStamp = new Date().getTime();
        note = "NO NOTES";
        customer = null;
        products = new ArrayList<>();
    }

    public double getMoneyTotal() {
        double sum = 0;
        for (Product o : products) {
            sum += o.getSellPrice() *
                    o.getDiscount() *
                    customer.getDiscount();
        }
        return sum;
    }

    public boolean addProduct(Product product) {
        if (product == null) return false;
        for (Product o : products) {
            if (o.getIdCode().equals(product.getIdCode()))
                return false;
        }
        products.add(product);
        return true;
    }

    public boolean rmvProduct(String idCode) {
        for (int i=0; i < products.size(); i++) {
            Product o = products.get(i);
            if (o.getIdCode().equals(idCode)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printInfo() {
        System.out.format("Ma phieu: %s, Thoi gian: %s, " +
                        "Ghi chu: %s, Ma KH: %s\n",
                idCode,
                new Date(timeStamp).toString(),
                note,
                customer.getIdCode()
                );
        System.out.println("Danh sach san pham dinh kem:");
        for (Product o : products) {
            System.out.format("Ma SP: %s, Ten: %s, " +
                            "Don gia: %s, So luong: %s, Chiet khau: %s\n",
                    o.getIdCode(),
                    o.getName(),
                    o.getSellUnitPrice(),
                    o.getQuantity(),
                    o.getDiscount()
                    );
        }
        System.out.println("Tong tien: " + getMoneyTotal());

    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getIdCode() {
        return idCode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product[] getProducts() {
        Product[] list = new Product[products.size()];
        return products.toArray(list);
    }

    private String idCode;
    private long timeStamp;
    private String note;
    private Customer customer;
    private ArrayList<Product> products;
}
