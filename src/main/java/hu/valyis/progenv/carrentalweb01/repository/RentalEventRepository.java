package hu.valyis.progenv.carrentalweb01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.valyis.progenv.carrentalweb01.model.RentalEvent;

public interface RentalEventRepository extends JpaRepository<RentalEvent,Integer> {
}
