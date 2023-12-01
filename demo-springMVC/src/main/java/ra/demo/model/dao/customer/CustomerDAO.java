package ra.demo.model.dao.customer;

import ra.demo.model.dao.IGenericDAO;
import ra.demo.model.entity.Customer;

import java.util.List;

public interface CustomerDAO extends IGenericDAO<Customer,Integer> {
    List<Customer> findByName(String name);
}
