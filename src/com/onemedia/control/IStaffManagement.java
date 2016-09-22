package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public interface IStaffManagement {
    public boolean saveStaffInfo(Staff staff);
    public Staff[] getStaffList();
    public Staff getStaffByTagCode(String tagCode);
}
