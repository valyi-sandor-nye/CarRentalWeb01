package hu.valyis.progenv.carrentalweb01.controller;


import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public List<Car> getAllCars()
    {return carService.getAllCars(); }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return  carService.getCarById(id).get();
    }

    @PostMapping()
    public String putCarIntoDb(@RequestBody Car car) {
        //carService.save(car);
        return car.getModel();
    }

    @DeleteMapping()
    public String deleteCarById( @PathVariable int id) {
        if (carService.deleteCarById(id)) return "törlés"; else return "nincs törlés";
    }

}

