package com.onemedia.view;
import com.onemedia.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class StaffInOut {

    public  StaffInOut(StoreManagement storeManagement){
        this.storeManagement = storeManagement;
    }

    public void run(Scanner sc) {
        while (true){
            System.out.println("QUAN LY NHAN VIEN");
            System.out.println("1.In danh sach");
            System.out.println("2.Them nhan vien");
            System.out.println("3.Sua nhan vien");
            System.out.println("4.Xoa nhan vien");
            System.out.println("5.Quay lai");
            System.out.println("Lua chon: ");
            try{
                int key = Integer.parseInt(sc.nextLine());
                switch (key){
                    case 1:
                        storeManagement.getStaffManagement().printInfo();
                        break;
                    case 2:
                        addProcess(sc);
                        break;
                    case 3:
                        modifyProcess(sc);
                        break;
                    case 4:
                        rmvProcess(sc);
                        break;
                    case 5:
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
        StaffManagement mgr = storeManagement.getStaffManagement();
        System.out.println("Ma nhan vien sau khi nhap se duoc he thong" +
                " bat dau bang 'NV'");
        System.out.print("Ma NV:");
        String idCode = "NV" + sc.nextLine();
        if (mgr.staffExisted(idCode)) {
            System.out.println("Ma NV da ton tai!");
            mgr.getStaffById(idCode);
            return;
        }

        Staff newStaff = new Staff();
        newStaff.setIdCode(idCode);

        System.out.print("Ten: ");
        newStaff.setName(sc.nextLine());

        System.out.print("Ngay sinh(yyyy-mm-dd): ");
        try {
            newStaff.setDateOfBirth(LocalDate.parse(sc.nextLine()));
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang," +
                    " he thong se cai dat ngay sinh mac dinh (2000-01-01)");
            newStaff.setDateOfBirth(LocalDate.parse("2000-01-01"));
        }

        System.out.print("Dia chi: ");
        newStaff.setAddress(sc.nextLine());

        System.out.print("Luong: ");
        try {
            newStaff.setSalary(Double.parseDouble(sc.nextLine()));
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai dinh dang," +
                    " he thong se cai dat luong mac dinh la 0");
            newStaff.setSalary(0);
        }

        System.out.println("Chuc vu: ");
        while (true) {
            System.out.println("1. Giam doc");
            System.out.println("2. Quan ly");
            System.out.println("3. Thu ngan");
            System.out.println("4. Nhan vien");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        addDirector(sc, newStaff);
                        return;
                    case 2:
                        addManager(sc, newStaff);
                        return;
                    case 3:
                        addCashier(sc, newStaff);
                        return;
                    case 4:
                        addstaff(sc, newStaff);
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai!");
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Ban nhap sai, hay nhap lai!");
            }
        }
    }

    private void addstaff(Scanner sc, Staff staff) {
        saveStaff(sc, staff);
    }

    private void addDirector(Scanner sc, Staff staff) {
        Director director = new Director(staff);

        System.out.print("Ten dang nhap:");
        director.setUser(sc.nextLine());

        System.out.print("Mat khau:");
        director.setPass(sc.nextLine());

        System.out.format("Phu cap dang duoc cai dat: %s\n", director.getAllowance());
        System.out.println("Neu muon thay doi, hay nhap gia tri moi, con khong" +
                " thi hay de trong!");
        System.out.print("Phu cap: ");
        try {
            double allowance = Double.parseDouble(sc.nextLine());
            director.setAllowance(allowance);
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai roi, phu cap se duoc giu nguyen!");
        }

        saveStaff(sc, director);
    }

    private void addManager(Scanner sc, Staff staff) {
        Manager manager = new Manager(staff);

        System.out.print("Ten dang nhap:");
        manager.setUser(sc.nextLine());

        System.out.print("Mat khau:");
        manager.setPass(sc.nextLine());

        System.out.format("Phu cap dang duoc cai dat: %s\n", manager.getAllowance());
        System.out.println("Neu muon thay doi, hay nhap gia tri moi, con khong" +
                " thi hay de trong!");
        System.out.print("Phu cap: ");
        try {
            double allowance = Double.parseDouble(sc.nextLine());
            manager.setAllowance(allowance);
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai roi, phu cap se duoc giu nguyen!");
        }

        saveStaff(sc, manager);
    }

    private void addCashier(Scanner sc, Staff staff) {
        Cashier cashier = new Cashier(staff);

        System.out.print("Ten dang nhap:");
        cashier.setUser(sc.nextLine());

        System.out.print("Mat khau:");
        cashier.setPass(sc.nextLine());

        saveStaff(sc, cashier);
    }

    private void saveStaff(Scanner sc, Staff staff) {
        System.out.println("Thong tin nhan vien moi:");
        staff.printInfo();
        System.out.print("Ban co luu khong?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            StaffManagement mgr = storeManagement.getStaffManagement();
            mgr.addStaff(staff);
        }
    }

    private void rmvProcess(Scanner sc) {
        System.out.print("ma NV: ");
        String idCode = sc.nextLine();
        StaffManagement mgr = storeManagement.getStaffManagement();
        Staff staff = mgr.getStaffById(idCode);
        if (staff != null) {
            staff.printInfo();
            System.out.print("Ban co chac chan xoa?(yes/no):");
            if (sc.nextLine().equals("yes")) {
                mgr.rmvStaff(idCode);
            }
        }
        else {
            System.out.println("Ma nhan vien khong ton tai");
        }
    }

    private void modifyProcess(Scanner sc) {
        StaffManagement mgr = storeManagement.getStaffManagement();
        System.out.print("Ma NV: ");
        String idCode = sc.nextLine();
        Staff staff = mgr.getStaffById(idCode);
        if (staff != null) {
            System.out.println("Thong tin truoc khi sua:");
            staff.printInfo();

            System.out.format("Ten(%s):", staff.getName());
            String str = sc.nextLine();
            if (!str.equals("")) {
                staff.setName(str);
            }

            System.out.format("Ngay sinh(%s):", staff.getDateOfBirth());
            str = sc.nextLine();
            if (!str.equals("")) {
                try {
                    staff.setDateOfBirth(LocalDate.parse(str));
                }
                catch (DateTimeParseException e) {
                    System.out.println("Ban nhap sai dinh dang!");
                }
            }

            System.out.format("Dia chi(%s):", staff.getAddress());
            str = sc.nextLine();
            if (!str.equals("")) {
                staff.setAddress(str);
            }

            System.out.format("Luong(%s):", staff.getSalary());
            str = sc.nextLine();
            if (!str.equals("")) {
                try {
                    Double salary = Double.parseDouble(sc.nextLine());
                    staff.setSalary(salary);
                }
                catch (NumberFormatException ex) {
                    System.out.println("Ban nhap sai luong!");
                }
            }

            if (staff instanceof Director) {
                Director director = (Director)staff;
                System.out.format("Ten dang nhap(%s):", director.getUser());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    director.setUser(str);
                }

                System.out.format("Mat khau(%s):", director.getPass());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    director.setPass(str);
                }

                System.out.format("Phu cap(%s):", director.getAllowance());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    try {
                        double allowance = Double.parseDouble(str);
                        director.setAllowance(allowance);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Ban nhap sai phu cap!");
                    }
                }

            }
            else if (staff instanceof Manager) {
                Manager manager = (Manager) staff;
                System.out.format("Ten dang nhap(%s):", manager.getUser());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    manager.setUser(str);
                }

                System.out.format("Mat khau(%s):", manager.getPass());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    manager.setPass(str);
                }

                System.out.format("Phu cap(%s):", manager.getAllowance());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    try {
                        double allowance = Double.parseDouble(str);
                        manager.setAllowance(allowance);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Ban nhap sai phu cap!");
                    }
                }
            }
            else if (staff instanceof Cashier) {
                Cashier cashier = (Cashier) staff;
                System.out.format("Ten dang nhap(%s):", cashier.getUser());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    cashier.setUser(str);
                }

                System.out.format("Mat khau(%s):", cashier.getPass());
                str = sc.nextLine();
                if (!sc.equals("")) {
                    cashier.setPass(str);
                }
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
