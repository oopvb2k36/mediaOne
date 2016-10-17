package com.onemedia.test;

import com.onemedia.control.*;
import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class SampleData {

    public static void MakeStaffs(StaffManagement mgr) {
        try {
            FileReader in = new FileReader("staffs.csv");
            BufferedReader reader = new BufferedReader(in);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(",");
                if (token[0].equals("director")) {
                    Director o = new Director();
                    initStaff(o, token);
                    o.setUser(token[6]);
                    o.setPass(token[7]);
                    o.setAllowance(Double.parseDouble(token[8]));
                    mgr.addStaff(o);
                }
                else if (token[0].equals("manager")) {
                    Manager o = new Manager();
                    initStaff(o, token);
                    o.setUser(token[6]);
                    o.setPass(token[7]);
                    o.setAllowance(Double.parseDouble(token[8]));
                    mgr.addStaff(o);
                }
                else if (token[0].equals("cashier")) {
                    Cashier o = new Cashier();
                    initStaff(o, token);
                    o.setUser(token[6]);
                    o.setPass(token[7]);
                    mgr.addStaff(o);
                }
                else {
                    Staff o = new Staff();
                    initStaff(o, token);
                    mgr.addStaff(o);
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initStaff(Staff staff, String[] token) {
        staff.setIdCode(token[1]);
        staff.setName(token[2]);
        staff.setDateOfBirth(LocalDate.parse(token[3]));
        staff.setAddress(token[4]);
        staff.setSalary(Double.parseDouble(token[5]));
    }

    public static void MakeCustomers(CustomerManagement mgr) {
        try {
            FileReader in = new FileReader("customers.csv");
            BufferedReader reader = new BufferedReader(in);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(",");
                Customer o = new Customer();
                o.setIdCode(token[0]);
                o.setName(token[1]);
                o.setAddress(token[2]);
                o.setDiscount(Double.parseDouble(token[3]));
                mgr.addCustomer(o);
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MakeProviders(ProviderManagement mgr) {
        try {
            FileReader in = new FileReader("providers.csv");
            BufferedReader reader = new BufferedReader(in);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(",");
                Provider o = new Provider();
                o.setIdCode(token[0]);
                o.setName(token[1]);
                o.setAddress(token[2]);
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MakeProducts(ProductManagement mgr) {
        try {
            FileReader in = new FileReader("products.csv");
            BufferedReader reader = new BufferedReader(in);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(",");
                if (token[0].equals("music")) {
                    Music o = new Music();
                    initProduct(o, token);
                    initMusic(o, token);
                    mgr.addProduct(o);
                }
                else if (token[0].equals("film")) {
                    Film o = new Film();
                    initProduct(o, token);
                    initFilm(o, token);
                    mgr.addProduct(o);
                }
                else if (token[0].equals("book")) {
                    Book o = new Book();
                    initProduct(o, token);
                    initBook(o, token);
                    mgr.addProduct(o);
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MakeExpenses(ExpenseManagement mgr) {
        try {
            FileReader in = new FileReader("expenses.csv");
            BufferedReader reader = new BufferedReader(in);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(",");
                ExpenseTag o = new ExpenseTag(token[0]);
                o.setPaidMoney(Double.parseDouble(token[1]));
                o.setNote(token[2]);
                mgr.addTag(o);
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initProduct(Product product, String[] token) {
        product.setIdCode(token[1]);
        product.setName(token[2]);
        product.setQuantity(Integer.parseInt(token[3]));
        product.setCostUnitPrice(Double.parseDouble(token[4]));
        product.setSellUnitPrice(Double.parseDouble(token[5]));
        product.setDiscount(Double.parseDouble(token[6]));
    }

    private static void initMusic(Music music, String[] token) {
        music.setArtist(token[7]);
        music.setGenre(token[8]);
        music.setIssuedDate(LocalDate.parse(token[9]));
    }

    private static void initFilm(Film film, String[] token) {
        film.setDirector(token[7]);
        film.setGenre(token[8]);
        film.setIssuedDate(LocalDate.parse(token[9]));
        film.setActor(token[10]);
    }

    private static void initBook(Book book, String[] token) {
        book.setAuthor(token[7]);
        book.setGenre(token[8]);
        book.setIssuedDate(LocalDate.parse(token[9]));
        book.setPublisher(token[10]);
    }
}
