package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Customer;

import java.util.List;

/**
 * Created by anton on 9/1/16.
 */
public interface CustomerDao
{
    Long addCustomer(Customer Customer);
    void updateCustomer(Customer Customer);
    Customer getCustomer(Long CustomerId);
    void deleteCustomer(Long CustomerId);
    List<Customer> findCustomer();
}
