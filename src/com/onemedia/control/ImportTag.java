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
        // TODO: Bổ sung tính tổng tiền phiếu

        /*
        Dựa vào đơn giá mua và số lượng để tính
         */
        return 0;
    }

    public boolean addProduct(Product product) {
        // TODO: Bổ sung thêm sản phẩm

        /*
        Kiểm tra idCode của product này đã có trong products chưa?
        Nếu chưa có thì thêm mới
         */
        return true;
    }

    public boolean rmvProduct(String idCode) {
        // TODO: Bổ sung xóa sản phẩm

        /*
        Dựa vào idCode để tìm trong products
         */
        return true;
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

    private String idCode;
    private long timeStamp;
    private String note;
    private Provider provider;
    private ArrayList<Product> products;
}
