package hu.valyis.progenv.carrentalweb01.controller;


import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/cars")
public class CarRESTController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public List<Car> getAllCars()
    {return carService.getAllCars(); }

    @GetMapping("api/cars/{id}")
    public Car getCarById(@PathVariable int id) {
        return  carService.getCarById(id);
    }

    @PostMapping()
    public Integer putCarIntoDb(@RequestBody Car car) {
        int answer = carService.insertOrUpdateCar(car);
        return answer;
    }

    @DeleteMapping("/{id}")
    public String deleteCarById( @PathVariable int id) {
        if(carService.deleteCarById(id)) return "car with id " +id+ " is deleted"; else return "nothing is deleted";
    }

}

