package ra.demo.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demo.model.dao.customer.CustomerDAO;
import ra.demo.model.entity.Customer;
import ra.demo.model.service.customer.CustomerService;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/getAll")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("cusList", customerList);
        return "customer/list";
    }

    @GetMapping("/create")
    public String formCreateCustomer(Model model) {
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        boolean check= customerService.saveOrUpdate(customer);
        if (check){
            return "redirect:getAll";
        }else {
            return "redirect:create";
        }
    }

    @GetMapping("/edit")
    public String formUpdate(Model model,int id){
        Customer customer=customerService.findById(id);
        model.addAttribute("custEdit",customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(Customer customer){
        boolean check = customerService.saveOrUpdate(customer);
        if (check){
            return "redirect:getAll";
        }else {
            return "redirect:edit";
        }
    }

}
