package hu.valyis.progenv.carrentalweb01.repository;

import hu.valyis.progenv.carrentalweb01.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
