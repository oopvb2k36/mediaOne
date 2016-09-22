package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public interface IProductManagement {
    public boolean saveProductInfo(Product product);
    public boolean saveImportTagInfo(ImportTag importTag);
    public boolean saveExporTagInfo(ExportTag exportTag);

    public Product[] getProductList();
    public ImportTag[] getImportTagList();
    public ExportTag[] getExportTagList();

    public Product getProductByTagCode(String tagCode);
    public ImportTag getImportTagByTagCode(String tagCode);
    public ExportTag getExportTagByTagCode(String tagCode);
}
