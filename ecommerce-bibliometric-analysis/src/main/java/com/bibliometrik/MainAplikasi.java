package com.bibliometrik;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import com.bibliometrik.database.KoneksiDatabase;

public class MainAplikasi {
    public static void main(String[] args) {
        while (true) {  // Main application loop
            // Selection
            int choice = showMenu();
            
            // Handle window close (X) or Cancel button
            if (choice == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
            
            switch (choice) {
                case 0:  // Input Data
                    inputData();
                    break;
                case 1:  // Display Data
                    displayData();
                    break;
                case 2:  // Update Data
                    updateData();
                    break;
                case 3:  // Delete Data
                    deleteData();
                    break;
                case 4:  // Exit
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Pilihan tidak valid.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static int showMenu() {
        String[] options = {"Input Data", "Display Data", "Update Data", "Delete Data", "Exit"};
        return JOptionPane.showOptionDialog(null, 
            "Pilih opsi:", 
            "Menu Utama",
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            options, 
            options[0]);
    }
    
    private static void inputData() {
        Connection conn = null;
        try {
            String name = JOptionPane.showInputDialog("Masukkan nama:");
            if (name == null) return; // Handle cancel button
            
            String ageStr = JOptionPane.showInputDialog("Masukkan umur:");
            if (ageStr == null) return; // Handle cancel button
            
            int age = Integer.parseInt(ageStr);
            
            // Input validation
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (age <= 0 || age > 150) {
                JOptionPane.showMessageDialog(null, "Umur tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Array
            String[] data = {name, String.valueOf(age)};
            
            conn = getConnection();
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
                stmt.setString(1, data[0]);
                stmt.setInt(2, Integer.parseInt(data[1]));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Umur harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat menyimpan data: " + e.getMessage(), 
                "Error Database", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection(conn);
        }
    }
    
    private static void displayData() {
        Connection conn = null;
        try {
            ArrayList<String[]> data = new ArrayList<String[]>();
            
            conn = getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY name");  // Added ORDER BY
                
                StringBuilder sb = new StringBuilder();
                boolean hasData = false;
                
                while (rs.next()) {
                    hasData = true;
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    sb.append("Nama: ").append(name).append(", Umur: ").append(age).append("\n");
                }
                
                if (!hasData) {
                    JOptionPane.showMessageDialog(null, "Tidak ada data yang tersedia.", 
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                JOptionPane.showMessageDialog(null, sb.toString(), "Data Pengguna", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mengambil data: " + e.getMessage(), 
                "Error Database", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection(conn);
        }
    }
    
    private static void updateData() {
        Connection conn = null;
        try {
            String name = JOptionPane.showInputDialog("Masukkan nama yang akan diupdate:");
            if (name == null) return; // Handle cancel button
            
            String ageStr = JOptionPane.showInputDialog("Masukkan umur baru:");
            if (ageStr == null) return; // Handle cancel button
            
            int newAge = Integer.parseInt(ageStr);
            
            // Input validation
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (newAge <= 0 || newAge > 150) {
                JOptionPane.showMessageDialog(null, "Umur tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            conn = getConnection();
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE users SET age = ? WHERE name = ?");
                stmt.setInt(1, newAge);
                stmt.setString(2, name);
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate.", 
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak ada data yang diupdate.", 
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Umur harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mengupdate data: " + e.getMessage(), 
                "Error Database", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection(conn);
        }
    }
    
    private static void deleteData() {
        Connection conn = null;
        try {
            String name = JOptionPane.showInputDialog("Masukkan nama yang akan dihapus:");
            if (name == null) return; // Handle cancel button
            
            // Input validation
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(null, 
                "Anda yakin ingin menghapus data untuk " + name + "?",
                "Konfirmasi Hapus", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            
            conn = getConnection();
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE name = ?");
                stmt.setString(1, name);
                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", 
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus.", 
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat menghapus data: " + e.getMessage(), 
                "Error Database", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection(conn);
        }
    }
    
    private static Connection getConnection() {
        Connection conn = KoneksiDatabase.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, 
                "Tidak dapat terhubung ke database. Silakan periksa koneksi MySQL Anda.", 
                "Error Database", 
                JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
    
    private static void closeConnection(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
