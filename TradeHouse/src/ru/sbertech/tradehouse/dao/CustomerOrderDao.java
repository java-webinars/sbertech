package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.CustomerOrder;
import ru.sbertech.tradehouse.exception.DaoException;

/**
 * Created by anton on 9/15/16.
 */
public interface CustomerOrderDao
{
    Long addCustomerOrder(CustomerOrder co) throws DaoException;
}
