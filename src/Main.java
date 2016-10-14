import com.onemedia.control.*;
import com.onemedia.test.SampleData;
import com.onemedia.view.*;

public class Main {
    public static void main(String[] args) {
        StoreManagement storeManagement = new StoreManagement();
        //StoreInOut storeInOut = new StoreInOut(storeManagement);
        //storeInOut.run();

        SampleData.MakeCustomers(storeManagement.getCustomerManagement());

        //CustomerInOut customerInOut = new CustomerInOut(storeManagement);
        //customerInOut.run();

        ExportInOut exportInOut = new ExportInOut(storeManagement);
        exportInOut.run();

        System.out.println("Ket thuc chuong trinh!");
    }
}
