package hu.valyis.progenv.carrentalweb01.repository;

import hu.valyis.progenv.carrentalweb01.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {}

