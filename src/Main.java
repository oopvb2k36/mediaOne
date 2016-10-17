import com.onemedia.control.*;
import com.onemedia.test.SampleData;
import com.onemedia.view.*;

public class Main {
    public static void main(String[] args) {
        StoreManagement storeManagement = new StoreManagement();

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
