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

    public Staff logIn(String idCode, String user, String pass) {
        Staff staff = staffManagement.getStaffById(idCode);
        if (staff != null) {
            if (staff instanceof Director) {
                Director director = (Director)staff;
                if (director.getUser().equals(user) &&
                        director.getPass().equals(pass)) {
                    loggedStaff = director;
                    return director;
                }
            }
            else if (staff instanceof Manager) {
                Manager manager = (Manager)staff;
                if (manager.getUser().equals(user) &&
                        manager.getPass().equals(pass)) {
                    loggedStaff = manager;
                    return manager;
                }
            }
            else if (staff instanceof Cashier) {
                Cashier cashier = (Cashier) staff;
                if (cashier.getUser().equals(user) &&
                        cashier.getPass().equals(pass)) {
                    loggedStaff = cashier;
                    return cashier;
                }
            }
        }
        return null;
    }

    public Staff logOut() {
        loggedStaff = null;
        return null;
    }

    public void printFinancialInfo() {
        double exSum = exportManagement.getMoneyTotal();
        double imSum = importManagement.getMoneyTotal();
        double expenseSum = expenseManagement.getMoneyTotal();
        double revenue = exSum - imSum - expenseSum;
        System.out.println("Tong thu: " + exSum);
        System.out.println("Tong chi: " + imSum);
        System.out.println("Chi phi ngoai: " + expenseSum);
        System.out.println("Loi nhuan: " + revenue);
    }

    public void printInfo() {
        System.out.println("Nhan vien dang nhap:");
        loggedStaff.printInfo();
        System.out.println("Thong tin cua hang:");
        store.printInfo();
    }

    public Staff getLoggedStaff() {
        return new Staff(loggedStaff);
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
        return staffManagement;
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
