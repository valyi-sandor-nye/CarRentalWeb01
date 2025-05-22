package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.exception.NosuchEntityException;
import hu.valyis.progenv.carrentalweb01.model.Car;
import hu.valyis.progenv.carrentalweb01.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceUnitTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    private List<Car> carList;
    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void setUp() {
        testCar1 = Car.builder()
                .id(1)
                .brand("Suzuki")
                .model("Swift")
                .buildYear(2020)
                .licensePlate("ABC123")
                .rentalPricePerDay(8000)
                .available(true)
                .numberOfSeats(5)
                .build();

        testCar2 = Car.builder()
                .id(2)
                .brand("Toyota")
                .model("Corolla")
                .buildYear(2019)
                .licensePlate("XYZ789")
                .rentalPricePerDay(10000)
                .available(false)
                .numberOfSeats(5)
                .build();

        carList = new ArrayList<>(List.of(testCar1, testCar2));
    }

    @Test
    void getAllCars_ReturnsAllCars() {
        // Arrange
        when(carRepository.findAll()).thenReturn(carList);

        // Act
        List<Car> result = carService.getAllCars();

        // Assert
        assertEquals(2, result.size());
        assertEquals(testCar1, result.get(0));
        assertEquals(testCar2, result.get(1));
        verify(carRepository, times(1)).findAll();
    }

    @Test
    void getCarById_ExistingId_ReturnsCar() {
        // Arrange
        when(carRepository.findById(1)).thenReturn(Optional.of(testCar1));

        // Act
        Car result = carService.getCarById(1);

        // Assert
        assertNotNull(result);
        assertEquals(testCar1.getId(), result.getId());
        assertEquals(testCar1.getBrand(), result.getBrand());
        verify(carRepository, times(1)).findById(1);
    }

    @Test
    void getCarById_NonExistingId_ThrowsException() {
        // Arrange
        when(carRepository.findById(999)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NosuchEntityException.class, () -> carService.getCarById(999));
        verify(carRepository, times(1)).findById(999);
    }

    @Test
    void insertOrUpdateCar_NewCar_ReturnsCorrectCount() {
        // Arrange
        Car newCar = Car.builder()
                .id(3)
                .brand("Honda")
                .model("Civic")
                .buildYear(2021)
                .licensePlate("DEF456")
                .rentalPricePerDay(9000)
                .available(true)
                .numberOfSeats(5)
                .build();

        when(carRepository.save(any(Car.class))).thenReturn(newCar);
        when(carRepository.count()).thenReturn(3L);

        // Act
        int result = carService.insertOrUpdateCar(newCar);

        // Assert
        assertEquals(3, result);
        verify(carRepository, times(1)).save(newCar);
        verify(carRepository, times(1)).flush();
        verify(carRepository, times(1)).count();
    }

    @Test
    void deleteCarById_ExistingId_ReturnsTrue() {
        // Arrange
        when(carRepository.findById(1)).thenReturn(Optional.of(testCar1));
        doNothing().when(carRepository).deleteById(1);

        // Act
        boolean result = carService.deleteCarById(1);

        // Assert
        assertTrue(result);
        verify(carRepository, times(1)).findById(1);
        verify(carRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteCarById_NonExistingId_ThrowsException() {
        // Arrange
        when(carRepository.findById(999)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NosuchEntityException.class, () -> carService.deleteCarById(999));
        verify(carRepository, times(1)).findById(999);
        verify(carRepository, never()).deleteById(anyInt());
    }
}