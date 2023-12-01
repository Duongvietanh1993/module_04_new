package ra.demo.model.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.model.dao.customer.CustomerDAO;
import ra.demo.model.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Customer customer) {
        return customerDAO.saveOrUpdate(customer);
    }

    @Override
    public Customer findById(Integer integer) {
        return customerDAO.findById(integer);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerDAO.findByName(name);
    }
}
