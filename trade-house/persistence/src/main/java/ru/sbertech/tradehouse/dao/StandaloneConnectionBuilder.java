package ru.sbertech.tradehouse.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by anton on 9/15/16.
 */
public class StandaloneConnectionBuilder implements ConnectionBuilder
{
    private String driverName;
    private String url;
    private String login;
    private String password;

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getConnection() throws Exception {
        Connection con = DriverManager.getConnection(url, login, password);
        return con;
    }
}
