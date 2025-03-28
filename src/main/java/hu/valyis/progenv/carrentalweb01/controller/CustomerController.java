package hu.valyis.progenv.carrentalweb01.controller;


import hu.valyis.progenv.carrentalweb01.model.Customer;
import hu.valyis.progenv.carrentalweb01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<Customer> getAllCustomers()
    {return
            customerService
                    .getAllCustomers(); }

}

