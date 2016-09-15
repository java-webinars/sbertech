package ru.sbertech.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

//        Statement stmt = con.createStatement();
//        int d = stmt.executeUpdate(
//                "INSERT INTO th_product (product_name) VALUES ('Product2')");
//        System.out.println(stmt.getClass().getCanonicalName());
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO th_product (product_name) VALUES (?)"
        );
        stmt.setString(1, "Product 1");
        stmt.executeUpdate();
        stmt.close();

        PreparedStatement stmt2 = con.prepareStatement(
                "SELECT * FROM th_product"
        );
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()) {
            long id = rs.getLong("product_id");
            String name = rs.getString(2);
            System.out.println(id + ":" + name);
        }
        rs.close();
        stmt2.close();

//        List<Product> pr = new ArrayList<>();
        // Здесь можено добавить много продуктов
//        for(Product g : pr) {
//            stmt.setString(1, g.getPorductName());
//            stmt.executeUpdate();
//        }

        con.close();
    }
}
