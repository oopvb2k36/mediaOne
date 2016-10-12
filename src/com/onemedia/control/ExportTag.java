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
        // TODO: Bổ sung tính tổng tiền trên phiếu

        /*
        Dựa vào đơn giá bán, số lượng để tính
         */
        return 0;
    }

    public boolean addProduct(Product product) {
        // TODO: Bổ sung thêm sản phẩm bán

        /*
        Kiểm tra idCode xem đã có trong products chưa?
        Nếu chưa có thì thêm mới
         */
        return true;
    }

    public boolean rmvProduct(String idCode) {
        // TODO: Bổ sung xóa sản phẩm

        /*
        Kiểm tra dựa trên idCode xem có trong products ko?
        Nếu có thì xóa bỏ
         */
        return true;
    }

    public void printInfo() {
        // TODO: Bổ sung in thông tin ra màn hình
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
        this.customer = new Customer(customer);
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    private String idCode;
    private long timeStamp;
    private String note;
    private Customer customer;
    private ArrayList<Product> products;
}
