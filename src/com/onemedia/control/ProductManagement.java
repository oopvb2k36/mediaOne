package com.onemedia.control;

import java.util.ArrayList;

public class ProductManagement {

    public ProductManagement() {
        products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        if (product == null) return false;
        for (int i=0; i < products.size(); i++) {
            product o = products.get(i);
            if (product.getIdCode().equals(product.getIdCode()))
                return false;
        return true;
    }

    public Product rmvProduct(String idCode) {
        for (int i=0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getIdCode().equals(idCode)) {
                products.remove(i);
                return product;
            }
        }
        /*
        return sản phẩm bị xóa
         */
        return null;
    }

    public boolean productExisted(String idCode) {
        for (int i=0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getIdCode().equals(idCode))
                return true;
        return false;
    }

    public Product getProductById(String idCode) {
        for (int i=0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getIdCode().equals(idCode))
                return product;
        return null;
    }

    public void printInfo() {
        for (Product o : products){
            o.printInfo();
        }
    }

    private ArrayList<Product> products;
}
