package ra.demo.model.service.customer;

import ra.demo.model.entity.Customer;
import ra.demo.model.service.IGenericService;

import java.util.List;

public interface CustomerService extends IGenericService<Customer,Integer> {
    List<Customer> findByName(String name);
}
