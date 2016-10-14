package com.onemedia.control;

import java.util.ArrayList;

public class ImportManagement {

    public ImportManagement() {
        importTags = new ArrayList<>();
    }

    public boolean addTag(ImportTag importTag) {
        String idCode = importTag.getIdCode();
        for (ImportTag o : importTags) {
            if (o.getIdCode().equals(idCode))return false;
        }

        importTags.add(importTag);
        return true;
    }

    public ImportTag rmvTag(String idCode) {
        for (int i=0; i < importTags.size(); i++) {
            ImportTag importTag = importTags.get(i);
            if (importTag.getIdCode().equals(idCode)) {
                importTags.remove(i);
                return importTag;
            }
        }
        return null;
    }

    public boolean tagExisted(String idCode) {
        for (ImportTag o : importTags) {
            if (o.getIdCode().equals(idCode)) return true;
        }
        return false;
    }

    public void printInfo() {
        for (ImportTag importTag : importTags) {
            importTag.printInfo();
        }
    }

    public double getMoneyTotal() {
        double sum = 0;
        for (ImportTag importTag : importTags) {
            sum += importTag.getMoneyTotal();
        }
        return sum;
    }

    private ArrayList<ImportTag> importTags;
}
