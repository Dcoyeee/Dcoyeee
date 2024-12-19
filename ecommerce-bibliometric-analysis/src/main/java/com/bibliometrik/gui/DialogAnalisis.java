package com.bibliometrik.gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class DialogAnalisis extends JDialog implements Serializable {

    // Menambahkan serialVersionUID untuk menangani versioning kelas saat serialisasi
    private static final long serialVersionUID = 1L;

    public DialogAnalisis(JFrame parent) {
        super(parent, "Analisis", true);

        setSize(400, 300);
        setLocationRelativeTo(parent);

        // Menetapkan layout untuk dialog
        setLayout(new BorderLayout());

        // Membuat panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Menambahkan komponen ke panel utama
        mainPanel.add(new JLabel("Analisis 1:"));
        mainPanel.add(new JTextField());
        mainPanel.add(new JLabel("Analisis 2:"));
        mainPanel.add(new JTextField());
        mainPanel.add(new JLabel("Analisis 3:"));
        mainPanel.add(new JTextField());

        // Menambahkan panel utama ke dialog
        add(mainPanel, BorderLayout.CENTER);

        // Menambahkan tombol di bagian bawah
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Simpan"));
        buttonPanel.add(new JButton("Batal"));
        add(buttonPanel, BorderLayout.SOUTH);
    }
}


//package com.bibliometrik.gui;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class DialogAnalisis extends JDialog {
//    public DialogAnalisis(JFrame parent) {
//        super(parent, "Analisis", true);
//        setSize(400, 300);
//        setLocationRelativeTo(parent);
//        
//        // Set the layout for the dialog
//        setLayout(new BorderLayout());
//        
//        // Create the main panel
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));
//        
//        // Add components to the main panel
//        mainPanel.add(new JLabel("Analisis 1:"));
//        mainPanel.add(new JTextField());
//        mainPanel.add(new JLabel("Analisis 2:"));
//        mainPanel.add(new JTextField());
//        mainPanel.add(new JLabel("Analisis 3:"));
//        mainPanel.add(new JTextField());
//        
//        // Add the main panel to the dialog
//        add(mainPanel, BorderLayout.CENTER);
//        
//        // Add buttons at the bottom
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(new JButton("Simpan"));
//        buttonPanel.add(new JButton("Batal"));
//        add(buttonPanel, BorderLayout.SOUTH);
//    }
//}