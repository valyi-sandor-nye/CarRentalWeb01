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

