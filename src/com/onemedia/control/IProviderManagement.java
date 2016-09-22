package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public interface IProviderManagement {
    public boolean saveProviderInfo(Provider provider);
    public Provider[] getProviderList();
    public Provider getProviderByTagCode(String tagCode);
}
