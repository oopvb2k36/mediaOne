package com.onemedia.control;

import java.util.ArrayList;

public class ProductManagement {

    public ProductManagement() {
        products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        // TODO: bổ sung thêm sản phẩm
        if (product == null) return false;
        for (int i=0; i < product.size(); i++) {
            product o = product.get(i);
            if (product.getIdCode().equals(product.getIdCode()))
                return false;
        return true;
    }

    public Product rmvProduct(String idCode) {
        // TODO: bổ sung xóa sản phẩm

        /*
        return sản phẩm bị xóa
         */
        return null;
    }

    public boolean productExisted(String idCode) {
        // TODO: bổ sung kiểm tra sản phẩm
        return true;
    }

    public Product getProductById(String idCode) {
        // TODO: bổ sung tìm kiếm sản phẩm
        return null;
    }

    public void printInfo() {
        // TODO: bổ sung in danh sách sản phẩm
    }

    private ArrayList<Product> products;
}
