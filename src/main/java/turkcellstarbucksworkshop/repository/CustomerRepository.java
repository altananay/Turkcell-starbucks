package turkcellstarbucksworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import turkcellstarbucksworkshop.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
