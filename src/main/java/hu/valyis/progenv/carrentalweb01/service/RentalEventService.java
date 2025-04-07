package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.model.Customer;
import hu.valyis.progenv.carrentalweb01.model.RentalEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalEventService {
    /* @Autowired
    CustomerService customerService;
    @Autowired
    CarService carService;
    private List<RentalEvent> rentalEvents = new ArrayList<RentalEvent>(List.of(
            RentalEvent.builder()
                    .id(1)
                    .car(carService.getCarById(1))
                    .customer(customerService.getCustomerById(1))
                    .rentalDate(LocalDate.of(2025, 3, 18))
                    .isClosed(true)
                    .totalCost(8000)
                    .returnDate(LocalDate.of(2025, 3, 20))
                    .build()));
    */

    private List<RentalEvent> rentalEvents = new ArrayList<RentalEvent>(List.of(
            RentalEvent.builder()
                    .id(1)
                    .car(new Car())
                    .customer(new Customer())
                    .rentalDate(LocalDate.of(2025, 3, 18))
                    .isClosed(true)
                    .totalCost(8000)
                    .returnDate(LocalDate.of(2025, 3, 20))
                    .build()));


    public List<RentalEvent> getAllRentalEvents() {
        return rentalEvents;
    }
}
