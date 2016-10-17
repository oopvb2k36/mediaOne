package com.onemedia.control;

import java.util.ArrayList;

public class StaffManagement {

    public StaffManagement() {
        staffs = new ArrayList<>();
    }

    public boolean addStaff(Staff staff) {
            if (staff == null) return false;
            for (int i=0; i < staffs.size(); i++) {
                Staff o = staffs.get(i);
                if (o.getIdCode().equals(staff.getIdCode()))
                    return false;
            }
            staffs.add(staff);
            return true;
        }

    public Staff rmvStaff (String idCode) {
        for (int i=0; i < staffs.size(); i++) {
            Staff staff = staffs.get(i);
            if (staff.getIdCode().equals(idCode)) {
                staffs.remove(i);
                return staffs;
            }
        }
        return null;
    }

    public boolean staffExisted(String idCode) {
        for (int i=0; i < staffs.size(); i++) {
            Staff staff = staffs.get(i);
            if (staff.getIdCode().equals(idCode))
                return true;
        }
        return false;
    }

    public Staff getStaffById(String idCode) {
        for (int i=0; i < staffs.size(); i++) {
            Staff staff = staffs.get(i);
            if (staff.getIdCode().equals(idCode))
                return staff;
        return null;
    }

    public void printInfo() {
        for (Staff o : staffs) {
            o.printInfo();
        }
    }


    private ArrayList<Staff> staffs;
}
