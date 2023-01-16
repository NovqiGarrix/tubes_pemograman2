package com.novqigarrix.java.database;

import com.novqigarrix.java.database.util.EnvProperty;

import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App {

    static {
        System.setProperty("JDBC_URL", Objects.requireNonNull(EnvProperty.getProperty("JDBC_URL")));
        System.setProperty("MYSQL_USERNAME", Objects.requireNonNull(EnvProperty.getProperty("MYSQL_USERNAME")));
        System.setProperty("MYSQL_PASSWORD", Objects.requireNonNull(EnvProperty.getProperty("MYSQL_PASSWORD")));
    }

    public static void main( String[] args )
    {
        System.out.println("Hello, World!");
    }
}
