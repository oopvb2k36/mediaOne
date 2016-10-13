package com.onemedia.control;

import java.util.ArrayList;

public class ImportManagement {

    public ImportManagement() {
        importTags = new ArrayList<>();
    }

    public boolean addTag(ImportTag importTag) {
        // TODO: bổ sung thêm phiếu nhập hàng
        return true;
    }

    public ImportTag rmvTag(String idCode) {
        // TODO: bổ sung xóa phiếu nhập

        /*
        return phiếu nhập bị xóa
         */
        return null;
    }

    public boolean tagExisted(String idCode) {
        // TODO: bổ sung kiểm tra phiếu nhập
        return true;
    }

    public void printInfo() {
        // TODO: bổ sung in danh sách phiếu nhập
    }

    public double getMoneyTotal() {
        // TODO: bổ sung tính tổng tiền
        return 0;
    }

    private ArrayList<ImportTag> importTags;
}
