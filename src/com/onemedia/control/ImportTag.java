package com.onemedia.control;

import java.util.ArrayList;
import java.util.Date;

public class ImportTag {

    public ImportTag(String idCode) {
        setIdCode(idCode);
        timeStamp = new Date().getTime();
        provider = null;
        note = "NO NOTES";
        products = new ArrayList<>();
    }

    public double getMoneyTotal() {
        double sum = 0;
        for (Product o : products) {
            sum += o.getCostPrice();
        }
        return sum;
    }

    public boolean addProduct(Product product) {
        String idCode = product.getIdCode();
        for (Product o : products) {
            if (o.getIdCode().equals(idCode)) return false;
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
                        "Ghi chu: %s, Ma NCC: %s\n",
                idCode,
                new Date(timeStamp).toString(),
                note,
                provider.getIdCode()
        );
        System.out.println("Danh sach san pham dinh kem:");
        for (Product o : products) {
            System.out.format("Ma SP: %s, Ten: %s, " +
                            "Don gia: %s, So luong: %s\n",
                    o.getIdCode(),
                    o.getName(),
                    o.getCostUnitPrice(),
                    o.getQuantity()
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

    public void setProvider(Provider provider) {
        this.provider = new Provider(provider);
    }

    public Provider getProvider() {
        return new Provider(provider);
    }

    public Product[] getProducts() {
        Product[] proList = new Product[products.size()];
        return products.toArray(proList);
    }

    private String idCode;
    private long timeStamp;
    private String note;
    private Provider provider;
    private ArrayList<Product> products;
}
