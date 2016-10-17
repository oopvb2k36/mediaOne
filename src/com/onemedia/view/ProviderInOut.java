package com.onemedia.view;
<<<<<<< Updated upstream
import com.onemedia.control.*;
import java.util.Scanner;
import java.util.InputMismatchException;
=======

import com.onemedia.control.*;

import java.util.InputMismatchException;
import java.util.Scanner;
>>>>>>> Stashed changes

/**
 * Created by Thomas Lewis on 10/13/2016.
 */
public class ProviderInOut {
    private Provider pnv;

    public ProviderInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }


    // Ham bat dau la ham run
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("QUAN LY NHA CUNG CAP");
        System.out.println("1. Them nha cung cap");
        System.out.println("2. Xoa nha cung cap");
        System.out.println("3. In thong tin");
        System.out.println("4. Thoat");
        try {
            System.out.println("Lua chon 1 2 3 hoac 4:");
            int key = sc.nextInt();
    // Re nhanh cac lua chon
            switch (key){

                case 1:
                    System.out.println("Them nha cung cap moi! \n ID nha cung cap moi:");
                        Scanner sc1 = new Scanner(System.in);
                        String idn = sc1.nextLine(); sc1.reset();
                // Kiem tra nha cung cap moi da ton tai chua
                    ProviderManagement providerManagement = new ProviderManagement();
                   boolean ktra= providerManagement.providerExisted(idn);

                    if (ktra = true ){
                        System.out.println("Nha cung cap nay da ton tai!");
                    }
                    else{
                        System.out.println("Ma nha cung cap se tu dong them tien to 'NCC' ");
                        String idcode = "NCC"+idn;
                        System.out.println("Ten nha cung cap moi: ");
                        String name = sc1.nextLine(); sc1.reset();
                        String address = sc1.nextLine(); sc1.reset();
                        Provider pvn = new Provider(idcode, name, address);
                    // Them nha cung cap
                        providerManagement.addProvider(pnv);
                    };

                    break;
                case 2:
<<<<<<< Updated upstream

                    break;
                case 3:
                    break;
                case 4:
                    break;
=======
                        Scanner sc2 = new Scanner(System.in); sc2.reset();
                        ProviderManagement providerManagement1 = new ProviderManagement();
                        System.out.println("Nhap ID nha cung cap can xoa");
                        String idx = sc2.nextLine(); sc2.reset();
                        boolean ktr2 = providerManagement1.providerExisted(idx);

                    if (ktra = false) {
                        System.out.println("Nha cung cap nay khong ton tai");
                    }
                    else{
                        providerManagement1.rmvProvider(idx);
                    }

                    break;
                case 3:
                        ProviderManagement providerManagement2 = new ProviderManagement();
                        providerManagement2.printInfo();
                    break;
                case 4:
                        return;
                default:
                    System.out.println("Ban da nhap sai, hay nhap lai!");
>>>>>>> Stashed changes
            }

        }

        catch (InputMismatchException ex) {
            System.out.println("Ban da nhap sai, hay nhap lai!");
        }

<<<<<<< Updated upstream
    }
        private StoreManagement storeManagement;

=======


    }
        private StoreManagement storeManagement;


>>>>>>> Stashed changes
}