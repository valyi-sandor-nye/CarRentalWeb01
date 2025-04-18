package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.exception.NosuchEntityException;
import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    private List<Car> cars = new ArrayList<Car>(List.of(
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
        return carRepository.findAll();
    }

    public Car getCarById(int id) {

        Optional<Car> optCar = carRepository.findById(id);
        if (optCar.isPresent()) {
            return optCar.get();
        }
        else throw new NosuchEntityException("THere is no car with id:" + id);
    }

    public int insertOrUpdateCar(Car car) {
        carRepository.save(car);
        carRepository.flush();
        return (int) carRepository.count();
    }

    public boolean deleteCarById (int id) {
        Optional<Car> carToDelete =  carRepository.findById(id);
        if (carToDelete.isPresent()) {
            carRepository.deleteById(id);
            return true;
        }
        else throw new NosuchEntityException("THere is no car to delete with id:" + id);

    }

    }

