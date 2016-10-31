package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Customer;

import java.util.List;

/**
 * Created by anton on 9/1/16.
 */
public class CustomerDaoImpl implements CustomerDao
{
    @Override
    public Long addCustomer(Customer Customer) {
        System.out.println("CustomerDAO Impl - addCustomer");
        return null;
    }

    @Override
    public void updateCustomer(Customer Customer) {

    }

    @Override
    public Customer getCustomer(Long CustomerId) {
        return null;
    }

    @Override
    public void deleteCustomer(Long CustomerId) {

    }

    @Override
    public List<Customer> findCustomer() {
        return null;
    }
}
