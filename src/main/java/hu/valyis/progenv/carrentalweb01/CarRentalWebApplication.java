package hu.valyis.progenv.carrentalweb01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalWebApplication.class, args);
		//System.out.println(new AuthorService().getAllAuthors());
		//System.out.println(new CarService().getAllCars());
	}

}
