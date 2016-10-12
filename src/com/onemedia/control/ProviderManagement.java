package com.onemedia.control;

import java.util.ArrayList;

public class ProviderManagement {

    public ProviderManagement() {
        providers = new ArrayList<>();
    }

    public boolean addProvider(Provider provider) {
        // TODO: bổ sung thêm nhà cung cấp

        /*
        Kiểm tra mã idCode của nhà cung cấp trước khi thêm
         */
        return true;
    }

    public Provider rmvProvider(String idCode) {
        // TODO: bổ sung xóa nhà cung cấp

        /*
        Kiểm tra mã idCode xem có tồn tại không?
        Nếu có thì xóa
        return nhà cung cấp bị xóa
         */
        return null;
    }

    public boolean providerExisted(String idCode) {
        // TODO: bổ sung kiểm tra mã nhà cung cấp
        return true;
    }

    public Provider getProviderById(String idCode) {
        // TODO: bổ sung tìm kiếm nhà cung cấp
        return null;
    }

    public void printInfo() {
        // TODO: bổ sung in danh sách nhà cung cấp
    }

    private ArrayList<Provider> providers;
}
