package hu.valyis.progenv.carrentalweb01.controller;

import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarWebController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String listCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car/list"; // A Thymeleaf template neve
    }

    @GetMapping("/{id}")
    public String showCarDetails(@PathVariable int id, Model model) {
        try {
            Car car = carService.getCarById(id);
            model.addAttribute("car", car);
            return "car/details"; // A Thymeleaf template neve
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error"; //
        }
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new Car()); // empty car for the form
        return "car/add"; // A Thymeleaf template neve
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
        carService.insertOrUpdateCar(car);
        return "redirect:/cars"; // return to the list of cars
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        try {
            Car car = carService.getCarById(id);
            model.addAttribute("car", car);
            return "car/edit"; // name of the  Thymeleaf template
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error"; // error page
        }
    }

    @PostMapping("/edit")
    public String updateCar(@ModelAttribute Car car) {
        carService.insertOrUpdateCar(car);
        return "redirect:/cars"; // return to the list of cars
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteCarById(id);
        return "redirect:/cars"; // return to the list of cars
    }
}