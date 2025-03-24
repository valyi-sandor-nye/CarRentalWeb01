package hu.valyis.progenv.carrentalweb01.controller;

import hu.valyis.progenv.carrentalweb01.model.RentalEvent;
import hu.valyis.progenv.carrentalweb01.service.RentalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("rentalevents")
public class RentalEventsController {

    @Autowired
    private RentalEventService rentalEventService;

    @GetMapping()
    public List<RentalEvent> getAllRentalEvents()
    {return rentalEventService.getAllRentalEvents(); }

}
