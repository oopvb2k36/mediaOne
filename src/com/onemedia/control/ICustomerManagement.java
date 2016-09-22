package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public interface ICustomerManagement {
    public boolean saveCustomerInfo(Customer customer);
    public Customer[] getCustomerList();
    public Customer getCustomerByTagCode(String tagCode);
}
