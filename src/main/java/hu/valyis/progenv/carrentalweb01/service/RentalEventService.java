package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.model.RentalEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalEventService {
    private List<RentalEvent> rentalEvents = List.of(
            RentalEvent.builder()
                    .id(1)
                    .carId(2)
                    .customerId(1)
                    .rentalDate(LocalDate.of(2025, 3, 18))
                    .isClosed(true)
                    .totalCost(8000)
                    .returnDate(LocalDate.of(2025, 3, 20))
                    .build()
    );

    public List<RentalEvent> getAllRentalEvents() {
        return rentalEvents;
    }
}
