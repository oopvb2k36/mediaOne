package com.onemedia.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import com.onemedia.control.*;

public class ProductInOut {
    public ProductInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run(Scanner sc) {
        while (true) {
            System.out.println("QUAN LY SAN PHAM");
            System.out.println("1.In danh sach san pham");
            System.out.println("2.Them san pham");
            System.out.println("3.Xoa san pham");
            System.out.println("4.Sua san pham");
            System.out.println("5.Quay lai");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        storeManagement.getProductManagement().printInfo();
                        break;
                    case 2:
                        addProcess(sc);
                        break;
                    case 3:
                        rmvProcess(sc);
                        break;
                    case 4:
                        modifyProcess(sc);
                    case 5:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai, hay nhap lai");
            }
        }
    }

    private void addProcess(Scanner sc) {
        System.out.println("Hay nhap ma san pham, he thong se tu dong them" +
                " tien to SP");
        ProductManagement mgr = storeManagement.getProductManagement();
        System.out.print("Ma SP:");
        String idCode = "SP" + sc.nextLine();
        if (mgr.productExisted(idCode)) {
            System.out.println("Ma san pham da ton tai!");
            mgr.getProductById(idCode).printInfo();
            return;
        }

        Product product = null;
        while (true) {
            System.out.println("Hay chon loai san pham!");
            System.out.println("1.Sach");
            System.out.println("2.Dia nhac");
            System.out.println("3.Dia phim");
            System.out.println("4.Thoat");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1: {
                        product = new Book();
                        product.setIdCode(idCode);
                        appendCommonInfo(sc, product);
                        addBook(sc, (Book)product);
                        return;
                    }
                    case 2: {
                        product = new Music();
                        product.setIdCode(idCode);
                        appendCommonInfo(sc, product);
                        addMusic(sc, (Music)product);
                        return;
                    }
                    case 3: {
                        product = new Film();
                        product.setIdCode(idCode);
                        appendCommonInfo(sc, product);
                        addFilm(sc, (Film)product);
                        return;
                    }
                    case 4:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai!");
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Ban nhap sai dinh dang!");
            }
        }

    }

    private void appendCommonInfo(Scanner sc, Product product) {
        System.out.print("Ten:");
        product.setName(sc.nextLine());

        System.out.print("So luong:");
        try {
            product.setQuantity(Integer.parseInt(sc.nextLine()));
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap so luong 0");
            product.setQuantity(0);
        }

        System.out.print("Don gia mua: ");
        try {
            product.setCostUnitPrice(Double.parseDouble(sc.nextLine()));
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap gia mua 0");
            product.setCostUnitPrice(0);
        }

        System.out.print("Don gia ban: ");
        try {
            product.setSellUnitPrice(Double.parseDouble(sc.nextLine()));
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap gia ban 0");
            product.setSellUnitPrice(0);
        }

        System.out.print("Chiet khau: ");
        try {
            product.setDiscount(Double.parseDouble(sc.nextLine()));
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap chiet khau 0");
            product.setDiscount(0);
        }
    }

    private void addBook(Scanner sc, Book book) {
        System.out.print("Tac gia: ");
        book.setAuthor(sc.nextLine());

        System.out.print("The loai: ");
        book.setGenre(sc.nextLine());

        System.out.print("Nha xuat ban: ");
        book.setPublisher(sc.nextLine());

        System.out.print("Ngay xuat ban(yyyy-mm-dd): ");
        try {
            book.setIssuedDate(LocalDate.parse(sc.nextLine()));
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap ngay 2000-01-01");
            book.setIssuedDate(LocalDate.parse("2000-01-01"));
        }
        saveProduct(sc, book);
    }

    private void addMusic(Scanner sc, Music music) {
        System.out.print("Nghe si: ");
        music.setArtist(sc.nextLine());

        System.out.print("The loai: ");
        music.setGenre(sc.nextLine());

        System.out.print("Ngay phat hanh(yyyy-mm-dd): ");
        try {
            music.setIssuedDate(LocalDate.parse(sc.nextLine()));
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap ngay 2000-01-01");
            music.setIssuedDate(LocalDate.parse("2000-01-01"));
        }
        saveProduct(sc, music);
    }

    private void addFilm(Scanner sc, Film film) {
        System.out.print("Dao dien: ");
        film.setDirector(sc.nextLine());

        System.out.print("Dien vien: ");
        film.setActor(sc.nextLine());

        System.out.print("The loai: ");
        film.setGenre(sc.nextLine());

        System.out.print("Ngay phat hanh(yyyy-mm-dd): ");
        try {
            film.setIssuedDate(LocalDate.parse(sc.nextLine()));
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang, he thong se tu dong" +
                    " thiet lap ngay 2000-01-01");
            film.setIssuedDate(LocalDate.parse("2000-01-01"));
        }
        saveProduct(sc, film);
    }

    private void saveProduct(Scanner sc, Product product) {
        System.out.println("Thong tin san pham moi:");
        product.printInfo();
        System.out.print("Ban co chac chan them khong?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            ProductManagement mgr = storeManagement.getProductManagement();
            if (mgr.addProduct(product)) {
                System.out.println("Luu thanh cong!");
            }
            else {
                System.out.println("Luu khong thanh cong!");
            }
        }
    }

    private void modifyProcess(Scanner sc) {
        ProductManagement mgr = storeManagement.getProductManagement();
        System.out.print("Ma SP:");
        String idCode = sc.nextLine();
        Product product = mgr.getProductById(idCode);
        if (product != null) {
            System.out.println("Thong tin truoc khi sua:");
            product.printInfo();
            modifyCommonInfo(sc, product);

            if (product instanceof Book) {
                modifyBook(sc, (Book)product);
            }
            else if (product instanceof Film) {
                modifyFilm(sc, (Film)product);
            }
            else {
                modifyMusic(sc, (Music)product);
            }

            System.out.println("Thong tin sau khi sua:");
            product.printInfo();
        }
        else {
            System.out.println("Khong ton tai ma san pham!");
        }
    }

    private void modifyCommonInfo(Scanner sc, Product product) {
        System.out.format("Ten SP(%s):", product.getName());
        String str = sc.nextLine();
        if (!str.equals("")) {
            product.setName(str);
        }

        System.out.format("So luong(%s):", product.getQuantity());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                product.setQuantity(Integer.parseInt(str));
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai so luong!");
        }

        System.out.format("Don gia mua(%s):", product.getCostUnitPrice());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                product.setCostUnitPrice(Double.parseDouble(str));
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai don gia mua!");
        }

        System.out.format("Don gia ban(%s):", product.getSellUnitPrice());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                product.setSellUnitPrice(Double.parseDouble(str));
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai don gia ban!");
        }

        System.out.format("Chiet khau(%s):", product.getDiscount());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                product.setDiscount(Double.parseDouble(str));
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ban nhap sai chiet khau!");
        }
    }

    private void modifyBook(Scanner sc, Book book) {
        System.out.format("Tac gia(%s):", book.getAuthor());
        String str = sc.nextLine();
        if (!str.equals("")) {
            book.setAuthor(str);
        }

        System.out.format("The loai(%s):", book.getGenre());
        str = sc.nextLine();
        if (!str.equals("")) {
            book.setGenre(str);
        }

        System.out.format("Nha xuat ban(%s):", book.getPublisher());
        str = sc.nextLine();
        if (!str.equals("")) {
            book.setPublisher(str);
        }

        System.out.format("Ngay xuat ban(%s):", book.getIssuedDate());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                book.setIssuedDate(LocalDate.parse(str));
            }
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang ngay xuat ban!");
        }
    }

    private void modifyMusic(Scanner sc, Music music) {
        System.out.format("Nghe si(%s):", music.getArtist());
        String str = sc.nextLine();
        if (!str.equals("")) {
            music.setArtist(str);
        }

        System.out.format("The loai(%s):", music.getGenre());
        str = sc.nextLine();
        if (!str.equals("")) {
            music.setGenre(str);
        }

        System.out.format("Ngay phat hanh(%s):", music.getIssuedDate());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                music.setIssuedDate(LocalDate.parse(str));
            }
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang ngay xuat ban!");
        }
    }

    private void modifyFilm(Scanner sc, Film film) {
        System.out.format("Dao dien(%s):", film.getDirector());
        String str = sc.nextLine();
        if (!str.equals("")) {
            film.setDirector(str);
        }

        System.out.format("Dien vien(%s):", film.getActor());
        str = sc.nextLine();
        if (!str.equals("")) {
            film.setActor(str);
        }

        System.out.format("The loai(%s):", film.getGenre());
        str = sc.nextLine();
        if (!str.equals("")) {
            film.setGenre(str);
        }

        System.out.format("Ngay phat hanh(%s):", film.getIssuedDate());
        try {
            str = sc.nextLine();
            if (!str.equals("")) {
                film.setIssuedDate(LocalDate.parse(str));
            }
        }
        catch (DateTimeParseException e) {
            System.out.println("Ban nhap sai dinh dang ngay xuat ban!");
        }
    }

    private void rmvProcess(Scanner sc) {
        System.out.print("Ma San Pham: ");
        String idCode = sc.nextLine();
        ProductManagement mgr = storeManagement.getProductManagement();
        Product product = mgr.getProductById(idCode);
        if (product != null) {
            product.printInfo();
            System.out.print("Ban co chac chan xoa?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.rmvProduct(idCode);
            }
        } else {
            System.out.println("Ma san pham khong ton tai");
        }
    }

    private StoreManagement storeManagement;
}
