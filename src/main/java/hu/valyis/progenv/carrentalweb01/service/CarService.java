package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private List<Car> cars = new ArrayList(List.of(
            Car.builder()
                    .id(1)
                    .available(true)
                    .licensePlate("EEF257")
                    .brand("Ford")
                    .model("Escort")
                    .buildYear(1992)
                    .numberOfSeats(5)
                    .rentalPricePerDay(4000)
                    .build()
            ,
            Car.builder()
                    .id(2)
                    .available(true)
                    .licensePlate("ABV016")
                    .brand("Trabant")
                    .model("1.1")
                    .buildYear(1984)
                    .numberOfSeats(4)
                    .rentalPricePerDay(4000)
                    .build()
            ,
            Car.builder()
                    .id(3)
                    .available(false)
                    .licensePlate("DSH906")
                    .brand("Skoda")
                    .model("Favorit")
                    .buildYear(1989)
                    .numberOfSeats(5)
                    .rentalPricePerDay(4000)
                    .build()
    ));

    public List<Car> getAllCars() {
        return cars;
    }

    public Optional<Car> getCarById(int id) {
        Optional<Car> optCar = cars.stream().filter(car -> car.getId() == id).findFirst();
        return optCar;
    }

    public int insertOrUpdateCar(Car car) {
        int id = car.getId();
        if (cars.stream().filter(c->(c.getId()==id)) != null) {
            cars.set(id,car);
        }
        else cars.add(car);
        return cars.size();
    }

    public boolean deleteCarById (int id) {
        Car carToDelete =  cars.stream().filter(c->(c.getId()==id)).findFirst().get();
        boolean answer = cars.remove(carToDelete);
        return answer;

    }

    }

