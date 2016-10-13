package com.onemedia.control;

import java.util.ArrayList;

public class ExportManagement {

    public ExportManagement() {
        exportTags = new ArrayList<>();
    }

    public boolean addTag(ExportTag exportTag) {
        if (exportTag == null) return false;
        for (ExportTag o : exportTags) {
            if (o.getIdCode().equals(exportTag.getIdCode()))
                return false;
        }
        exportTags.add(exportTag);
        return true;
    }

    public ExportTag rmvTag(String idCode) {
        for (int i=0; i < exportTags.size(); i++) {
            ExportTag exportTag = exportTags.get(i);
            if (exportTag.getIdCode().equals(idCode)) {
                exportTags.remove(i);
                return exportTag;
            }
        }
        return null;
    }

    public boolean tagExisted(String idCode) {
        for (ExportTag exportTag : exportTags) {
            if (exportTag.getIdCode().equals(idCode))
                return true;
        }
        return false;
    }

    public void printInfo() {
        for (ExportTag exportTag : exportTags) {
            exportTag.printInfo();
        }
    }

    public double getMoneyTotal() {
        double sum = 0;
        for (ExportTag exportTag : exportTags) {
            sum += exportTag.getMoneyTotal();
        }
        return sum;
    }

    private ArrayList<ExportTag> exportTags;
}
