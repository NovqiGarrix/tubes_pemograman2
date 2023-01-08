package com.novqigarrix.java.database;

import com.novqigarrix.java.database.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {

    @Test
    void testGetDataSource() {
        DatabaseUtil.getDataSource();
    }

    @Test
    void testGetConnection() {
        try {
            HikariDataSource hikariDataSource = DatabaseUtil.getDataSource();
            Connection conn = hikariDataSource.getConnection();

            System.out.println("Sukses konek ke database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
