package hu.valyis.progenv.carrentalweb01.controller;


import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public List<Car> getAllCars()
    {return carService.getAllCars(); }

}

