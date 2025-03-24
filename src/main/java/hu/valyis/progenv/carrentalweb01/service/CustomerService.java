package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers = List.of(
            Customer.builder()
                    .id(1)
                    .firstName("Sándor")
                    .lastName("Vályi")
                    .countryCode("hu")
                    .driverLicenseNumber("abc")
                    .email("vs@nye.hu")
                    .phoneNumber("4612")
                    .build()
    );

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
