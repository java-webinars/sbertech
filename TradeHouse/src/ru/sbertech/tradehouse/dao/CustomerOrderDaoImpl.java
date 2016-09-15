package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.CustomerOrder;
import ru.sbertech.tradehouse.domain.CustomerOrderItem;
import ru.sbertech.tradehouse.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Created by anton on 9/15/16.
 */
public class CustomerOrderDaoImpl implements CustomerOrderDao
{
    private Connection getConnection() throws DaoException {
        try {
            return ConnectionBuilderFactory.getConnectionBuilder().getConnection();
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage(), 3L);
        }
    }

    @Override
    public Long addCustomerOrder(CustomerOrder co) throws DaoException {
        try (Connection con = getConnection()) {
            con.setAutoCommit(false);
            try {
                PreparedStatement stmt = con.prepareStatement(
                        "INSERT INTO th_order (customer_id, order_date) VALUES (?, ?)",
                        new String[] {"order_id"}
                );
                stmt.setString(1, co.getCustomer().getCustomerId());
                stmt.setTimestamp(2, new Timestamp(co.getCustomerDate().getTime()));
                stmt.executeUpdate();

                Long coId = null;
                ResultSet grs = stmt.getGeneratedKeys();
                if(grs.next()) {
                    coId = grs.getLong(1);
                }
                grs.close();
                stmt.close();

                PreparedStatement stmt2 = con.prepareStatement(
                    "INSERT INTO th_order_item (order_id, product_id, quantity, price) " +
                            "VALUES (?, ?, ?, ?)"
                );

                int counter = 0;
                for(CustomerOrderItem coi : co.getItems()) {
                    stmt2.setLong(1, coId);
                    stmt2.setLong(2, coi.getProduct().getProductId());
                    stmt2.setInt(3, coi.getQuantity());
                    stmt2.setDouble(4, coi.getPrice());

//                    stmt2.executeUpdate();
                    stmt2.addBatch();
                    counter++;
                    if(counter > 3) {
                        System.out.println("Execute Batch in FOR:" + counter);
                        counter = 0;
                        stmt2.executeBatch();
                    }
                }
                if(counter > 0) {
                    System.out.println("Execute Batch for END:" + counter);
                    stmt2.executeBatch();
                }

                con.commit();
                return coId;
            } catch (Exception ex) {
                con.rollback();
                throw new DaoException(ex.getMessage(), 2L);
            }
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage(), 3L);
        }
    }
}
