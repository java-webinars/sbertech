package ru.sbertech.tradehouse.business;

import ru.sbertech.tradehouse.dao.CustomerOrderDao;
import ru.sbertech.tradehouse.domain.CustomerOrder;
import ru.sbertech.tradehouse.exception.DaoException;

/**
 * Created by anton on 9/15/16.
 */
public class CustomerOrderManager
{
    private CustomerOrderDao dao;

    public void setDao(CustomerOrderDao dao) {
        this.dao = dao;
    }

    public Long addCustomerOrder(CustomerOrder co) {
        try {
            return dao.addCustomerOrder(co);
        } catch(DaoException ex) {
            ex.printStackTrace();
        }
        return 0L;
    }
}
