package ra.demo.model.dao.customer;

import org.springframework.stereotype.Component;
import ra.demo.model.entity.Customer;
import ra.demo.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public List<Customer> findAll() {
        Connection connection = null;
        List<Customer> customers = new ArrayList<>();

        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_CUSTOMER()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return customers;
    }

    @Override
    public boolean saveOrUpdate(Customer customer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        int check;
        try {
            if (customer.getCustomerId() == 0) {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_CREATE_CUSTOMER(?,?,?)}");
                callableStatement.setString(1, customer.getCustomerName());
                callableStatement.setString(2, customer.getAddress());
                callableStatement.setString(3, customer.getEmail());
                check = callableStatement.executeUpdate();
            }else {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_UPDATE_CUSTOMER(?,?,?,?)}");
                callableStatement.setInt(1, customer.getCustomerId());
                callableStatement.setString(2, customer.getCustomerName());
                callableStatement.setString(3, customer.getAddress());
                callableStatement.setString(4, customer.getEmail());
                check = callableStatement.executeUpdate();
            }
            if (check>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Customer findById(Integer integer) {
        Connection connection = null;
        Customer customer = new Customer();
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_CUSTOMER(?)}");
            callableStatement.setInt(1, integer);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        Connection connection = null;
        List<Customer> customers = new ArrayList<>();
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_CUSTOMER(?)}");
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer=new Customer();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return customers;
    }
}
