package com.onemedia.control;

import java.util.ArrayList;

public class StaffManagement {

    public StaffManagement() {
        staffs = new ArrayList<>();
    }

    public boolean addStaff(Staff staff) {
        // TODO: bổ sung lưu thông tin nhân viên

        /*
        Kiểm tra idCode xem đã tồn tại chưa?
        Nếu chưa có thì thêm mới
         */
        return true;
    }

    public Staff rmvStaff(String idCode) {
        // TODO: bổ sung xóa nhân viên
        /*
        Tìm xem có tồn tại mã nhân viên đó không?
        Nếu có thì xóa
        return nhân viên bị xóa
         */
        return null;
    }

    public boolean staffExitsed(String idCode) {
        // TODO: bổ sung kiểm tra mã nhân viên
        return true;
    }

    public Staff getStaffById(String idCode) {
        // TODO: bổ sung tìm kiếm nhân viên
        return null;
    }

    public void printInfo() {
        // TODO: bổ sung in thông tin toàn bộ nhân viên
    }


    private ArrayList<Staff> staffs;
}
