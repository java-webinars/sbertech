package ru.sbertech.db;

import java.sql.*;

/**
 * Created by anton on 9/12/16.
 */
public class DbExample
{
    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "postgres";

        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();
        System.out.println(stmt.getClass().getCanonicalName());
        int d = stmt.executeUpdate(
                "INSERT INTO th_product (product_name) VALUES ('Product2')");
        stmt.close();

        Statement stmt2 = con.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT * FROM th_product");
        while(rs.next()) {
            long id = rs.getLong("product_id");
            String name = rs.getString(2);
            System.out.println(id + ":" + name);
        }
        rs.close();
        stmt2.close();

        con.close();
    }
}
