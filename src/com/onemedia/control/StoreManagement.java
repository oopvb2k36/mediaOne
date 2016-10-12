package com.onemedia.control;

public class StoreManagement {

    public StoreManagement() {
        loggedStaff = null;
        store = null;
        productManagement = new ProductManagement();
        staffManagement = new StaffManagement();
        customerManagement = new CustomerManagement();
        providerManagement = new ProviderManagement();
        importManagement = new ImportManagement();
        exportManagement = new ExportManagement();
        expenseManagement = new ExpenseManagement();

    }

    public Staff logIn(String user, String pass) {
        // TODO: bổ sung đăng nhập hệ thống

        /*
        return nhân viên đã đăng nhập thành công, null nếu thất bại
         */
        return null;
    }

    public Staff logOut() {
        // TODO: bổ sung đăng xuất hệ thống

        /*
        return nhân viên đã đăng xuất, null nếu chưa đăng nhập
         */
        return null;
    }

    public void printFinancialInfo() {
        // TODO: bổ sung in thông tin tài chính

        /*
        Thông tin ở đây đơn giản bao gồm:
        - Tổng thu
        - Tổng chi (sản phẩm)
        - Tổng chi ngoài (lương, tiền điện, nước...)
         */
    }

    public void printInfo() {
        // TODO: bổ sung in thông tin cửa hàng
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public ProductManagement getProductManagement() {
        return productManagement;
    }

    public StaffManagement getStaffManagement() {
        if (loggedStaff instanceof Director) {
            return staffManagement;
        }
        else return null;
    }

    public CustomerManagement getCustomerManagement() {

        return customerManagement;
    }

    public ProviderManagement getProviderManagement() {
        return providerManagement;
    }

    public ImportManagement getImportManagement() {
        return importManagement;
    }

    public ExportManagement getExportManagement() {
        return exportManagement;
    }

    public ExpenseManagement getExpenseManagement() {
        return expenseManagement;
    }

    private static Staff loggedStaff;
    private Store store;
    private ProductManagement productManagement;
    private StaffManagement staffManagement;
    private CustomerManagement customerManagement;
    private ProviderManagement providerManagement;
    private ImportManagement importManagement;
    private ExportManagement exportManagement;
    private ExpenseManagement expenseManagement;
}
