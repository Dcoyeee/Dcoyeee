package com.bibliometrik.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {
    // Perbarui konstanta ini dengan kredensial MySQL Anda
    private static final String URL = "jdbc:mysql://localhost:3306/bibliometrik";
    private static final String USERNAME = "root";  // Ganti dengan username MySQL Anda
    private static final String PASSWORD = "";      // Ganti dengan password MySQL Anda

    public static Connection getConnection() {
        try {
            // Menggunakan class driver yang baru
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Koneksi Database: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}





//package com.bibliometrik.database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class KoneksiDatabase {
//    private static final String URL = "jdbc:mysql://localhost:3306/bibliometrik\n"
//    		+ "";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "";
//
//    public static Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}