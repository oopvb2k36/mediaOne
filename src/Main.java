import com.onemedia.control.*;
import com.onemedia.test.SampleData;
import com.onemedia.view.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("One Media");
        store.setDirector("1L2H3T Group KS2 K36");
        store.setAddress("Dai hoc Bach Khoa Ha Noi");
        store.setPhone("0123456789");
        store.setWebsite("www.onemedia.com");
        store.setTaxCode("12345678");
        StoreManagement storeManagement = new StoreManagement();
        storeManagement.setStore(store);

        SampleData.MakeStaffs(storeManagement.getStaffManagement());
        SampleData.MakeCustomers(storeManagement.getCustomerManagement());
        SampleData.MakeProviders(storeManagement.getProviderManagement());
        SampleData.MakeProducts(storeManagement.getProductManagement());
        SampleData.MakeExpenses(storeManagement.getExpenseManagement());

        StoreInOut storeInOut = new StoreInOut(storeManagement);
        storeInOut.run();

        System.out.println("Ket thuc chuong trinh!");
    }
}
