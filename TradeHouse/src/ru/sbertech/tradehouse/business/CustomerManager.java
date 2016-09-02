package ru.sbertech.tradehouse.business;

import ru.sbertech.tradehouse.dao.CustomerDao;
import ru.sbertech.tradehouse.domain.Customer;

import java.util.List;

/**
 * Created by anton on 9/1/16.
 */
public class CustomerManager
{
    private CustomerDao dao;

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    public Long addCustomer(Customer Customer) {
        Long id = dao.addCustomer(Customer);

        return id;
    }

    public void updateCustomer(Customer Customer) {
        dao.updateCustomer(Customer);
    }

    public Customer getCustomer(Long CustomerId) {
        return dao.getCustomer(CustomerId);
    }

    public void deleteCustomer(Long CustomerId) {
        dao.deleteCustomer(CustomerId);
    }

    public List<Customer> findCustomer() {
        return dao.findCustomer();
    }

}
