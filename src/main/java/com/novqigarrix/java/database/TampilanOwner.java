package com.novqigarrix.java.database;

import com.novqigarrix.java.database.model.ProductTransactionModel;
import com.novqigarrix.java.database.repository.TransactionRepositoryImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class TampilanOwner extends JFrame {

    private JPanel mainPanel;
    private JTable mainTable;

    TampilanOwner() {
        super("Tampilan Owner");

        this.setContentPane(mainPanel);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID PRODUK");
        model.addColumn("NAMA PRODUK");
        model.addColumn("TERJUAL");
        model.addColumn("STOCK");
        model.addColumn("HARGA BELI");
        model.addColumn("HARGA JUAL");

        TransactionRepositoryImpl repo = new TransactionRepositoryImpl();

        try {

            ProductTransactionModel[] dataTransaksi = repo.findAllProductAndTransactions();

            for (ProductTransactionModel data : dataTransaksi) {
                Object[] row = {
                        data.getIdProduk(),
                        data.getNamaProduk(),
                        data.getTerjual(),
                        data.getStok(),
                        "$" + data.getHargaBeli(),
                        "$" + data.getHarga()
                };
                model.addRow(row);
            }

            mainTable = new JTable(model);

        } catch (SQLException e) {
            System.out.println("Terjadi error saat mengambil data transaksi di database!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
