package ru.sbertech.tradehouse.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by anton on 9/15/16.
 */
public class StandaloneConnectionBuilder implements ConnectionBuilder
{
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        return con;
    }
}
