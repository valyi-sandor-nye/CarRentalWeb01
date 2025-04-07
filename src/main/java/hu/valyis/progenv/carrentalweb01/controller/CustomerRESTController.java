package hu.valyis.progenv.carrentalweb01.controller;


import hu.valyis.progenv.carrentalweb01.exception.NosuchEntityException;
import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.model.Customer;
import hu.valyis.progenv.carrentalweb01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/customers")
public class CustomerRESTController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<Customer> getAllCustomers()
    {return
            customerService
                    .getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }


    @PostMapping()
    public Customer putCustomerIntoDb(@RequestBody Customer cust) {
        Customer answer = customerService.insertOrUpdateCustomer(cust);
        return answer;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById( @PathVariable int id) {
        if(customerService.deleteCustomerById(id)) return "customer with id " +id+ " is deleted"; else return "no customer is deleted";
    }

}

