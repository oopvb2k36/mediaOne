package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public interface ISystemManagement {
    public Staff logIn(String code, String pass);
    public Staff logOut();
}
