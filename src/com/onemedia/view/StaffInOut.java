package com.onemedia.view;
import com.onemedia.control.*;

import java.time.LocalDate;
import java.util.Scanner;

public class StaffInOut {
    private StoreManagement storeManagement ;
    public  StaffInOut(StoreManagement storeManagement){
        this.storeManagement = storeManagement;
    }
    //Ham bat dau la ham run
    public void run();
    Scanner sc = new Scanner(System.in);
    while (true){
        System.out.println("QUAN LY NHAN VIEN");
        System.out.println("1.Hien thi thong tin nhan vien");
        System.out.println("2.Xoa nhan vien");
        System.out.println("3.Sua thong tin nhan vien");
        System.out.println("4.Them nhan vien");
        System.out.println("5.Thoat");
        System.out.println("Lua chon: ");
        try{
            int key = Integer.parseInt(sc.nextLine();
            switch (key){
                case 1:
                    storeManagement.getStaffManagement().printInfo();
                    break;
                case 2:
                    addProcess(sc);
                    break;
                case 3:
                    rmvProcess(sc);
                    break;
                case 4:
                    modifyProcess(sc);
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Ban nhap sai, hay nhap lai");
                    break;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Ban nhap sai, hay nhap lai");
        }
    }
}
    private void addProcess(Scanner sc) {
        sc.reset();
        Staff staff = addProcess(sc);
        if (staff == null) return;

        staff.printInfo();

        Staff newStaff  = null;
        if (staff instanceof Director) {
            newStaff = new Director((Director)staff);
        }
        else if (staff instanceof Manager) {
            newStaff = new Manager((Manager)staff);
        }
        else {
            newStaff = new Cashier((Cashier)staff);
        }
        System.out.println("Ma nhan vien sau khi nhap se duoc he thong" +
                " bat dau bang 'NV'");
        System.out.print("Ma NV:");
        String idCode = "NV" + sc.nextLine();

        StaffManagement mgr = storeManagement.getStaffManagement();
        if (mgr.staffExisted(idCode)) {
            System.out.println("Ma NV da ton tai");
            mgr.getStaffById(idCode).printInfo();
        }
        else {
            Staff staff = new Staff(idCode, "NO NAME");
            System.out.print("Ten:");
            public LocalDate (int DOB, int MOB,int YOB);
            
            staff.setName(sc.nextLine());
            System.out.print("Dia chi:");
            staff.setAddress(sc.nextLine());
            System.out.print("Luong:");
            try {
                double num = Double.parseDouble(sc.nextLine());
                staff.setSalary(num);
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai luong!");
            }

            System.out.println("Thong tin nhan vien duoc them:");
            staff.printInfo();
            System.out.print("Ban co them khong?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.addStaff(staff);
            }
        }
    }
    private void rmvProcess(Scanner sc) {
        sc.reset();
        System.out.print("ma NV: ");
        String idCode = sc.nextLine();
        StaffManagement mgr = storeManagement.getStaffManagement();
        Staff staff = mgr.getStaffById(idCode);
        if (staff != null) {
            staff.printInfo();
            System.out.print("Ban co chac chan xoa?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.rmvStaff(idCode);
            }
        }
        else {
            System.out.println("Ma nhan vien khong ton tai");
        }

    }
    private void modifyProcess(Scanner sc) {
        System.out.print("Ma NV: ");
        String idCode = sc.nextLine();
        StaffManagement mgr = storeManagement.getStaffManagement();
        Staff staff = mgr.getStaffById(idCode);
        if (staff != null) {
            System.out.println("Thong tin truoc khi sua:");
            staff.printInfo();

            String str = "";
            System.out.format("Ten(%s):", staff.getName());
            String name = sc.nextLine();

            System.out.format("Dia chi(%s):", staff.getAddress());
            String address = sc.nextLine();

            System.out.format("Luong(%s):", staff.getSalary());
            double salary = -1;
            try {
                salary = Double.parseDouble(sc.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai luong!");
            }

            System.out.print("Ban co sua khong?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                if (!name.equals("")) staff.setName(name);
                if (!address.equals("")) staff.setAddress(address);
                if (salary >= 0) staff.setSalary(salary);
            }

            System.out.println("Thong tin sau khi sua:");
            staff.printInfo();
        }
        else {
            System.out.println("Ma nhan vien khong ton tai");
        }
    }


    private StoreManagement storeManagement;
}
