package com.onemedia.control;

import java.util.ArrayList;

public class ExportManagement {

    public ExportManagement() {
        exportTags = new ArrayList<>();
    }

    public boolean addTag(ExportTag exportTag) {
        // TODO: bổ sung thêm phiếu xuất hàng
        return true;
    }

    public ExportTag rmvTag(String idCode) {
        // TODO: bổ sung xóa phiếu xuất

        /*
        return phiếu xuất bị xóa
         */
        return null;
    }

    public boolean tagExisted(String idCode) {
        // TODO: bổ sung kiểm tra phiếu xuất
        return true;
    }

    public void printInfo() {
        // TODO: bổ sung in danh sách phiếu xuất
    }

    private ArrayList<ExportTag> exportTags;
}
