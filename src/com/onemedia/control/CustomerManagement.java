package com.onemedia.control;

import java.util.ArrayList;

public class CustomerManagement {

    public CustomerManagement() {
        customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {
        // TODO: bổ sung thêm khách hàng

        /*
        Kiểm tra xem đã tồn tại mã khách hàng chưa
        Nếu chưa thì thêm mới
         */
        return true;
    }

    public Customer rmvCustomer(String idCode) {
        // TODO: bổ sung xóa khách hàng

        /*
        Kiểm tra mã khách hàng, nếu có thì xóa
        return khách hàng bị xóa
         */
        return null;
    }

    public boolean customerExisted(String idCode) {
        // TODO: bổ sung kiểm tra mã khách hàng
        return true;
    }

    public Customer getCustomerById(String idCode) {
        // TODO: bổ sung tìm kiếm khách hàng
        return null;
    }

    public void printInfo() {
        // TODO: bổ sung in danh sách khách hàng
    }

    private ArrayList<Customer> customers;
}
