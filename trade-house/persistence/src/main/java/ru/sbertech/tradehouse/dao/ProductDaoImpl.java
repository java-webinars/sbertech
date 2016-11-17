package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao
{
    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws Exception {
        return connectionBuilder.getConnection();
    }

    public Long addProduct(Product product) throws DaoException {
//        if (product == null || product.getProductName() == null
//                || product.getProductName().trim().isEmpty()) {
//            throw new DaoException("Wrong Product info", 1L);
//        }

        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO th_product (product_name) VALUES (?)",
                    new String[] {"product_id"}
            );
            stmt.setString(1, product.getProductName());
            stmt.executeUpdate();

            Long id = null;
            ResultSet grs = stmt.getGeneratedKeys();
            if(grs.next()) {
                id = grs.getLong(1);
            }
            grs.close();
            stmt.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage(), 2L);
        }

// Java < 1.7
//        try {
//            Connection con = getConnection();
//            try {
//                PreparedStatement stmt = con.prepareStatement(
//                        "INSERT INTO th_product VALUES (?)"
//                );
//                stmt.setString(1, product.getProductName());
//                stmt.executeUpdate();
//                stmt.close();
//            } catch(Exception e) {
//                throw new DaoException(e.getMessage(), 3L);
//            } finally {
//                con.close();
//            }
//
//            return 99L;
//        } catch(Exception e) {
//            throw new DaoException(e.getMessage(), 2L);
//        }
    }

    public void updateProduct(Product product) throws DaoException {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE th_product SET product_name = ? WHERE product_id = ?"
            );
            stmt.setString(1, product.getProductName());
            stmt.setLong(2, product.getProductId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException(e.getMessage(), 2L);
        }
    }

    public Product getProduct(Long productId) throws DaoException {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT product_id, product_name " +
                            "FROM th_product WHERE product_id = ?"
            );
            stmt.setLong(1, productId);
            Product result = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                result = new Product(rs.getLong("product_id"),
                        rs.getString("product_name"));
            }
            return result;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), 2L);
        }
    }

    public void deleteProduct(Long productId) throws DaoException {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "DELETE FROM th_product WHERE product_id = ?"
            );
            stmt.setLong(1, productId);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException(e.getMessage(), 2L);
        }
    }

    public List<Product> findProduct() throws DaoException {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT product_id, product_name " +
                            "FROM th_product ORDER BY product_name"
            );
            List<Product> result = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Product p = new Product(rs.getLong("product_id"),
                        rs.getString("product_name"));
                result.add(p);
            }
            return result;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), 2L);
        }
    }
}
