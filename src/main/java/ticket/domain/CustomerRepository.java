package ticket.domain;

import stereotypes.Repository;
import ticket.domain.user.Customer;
import ticket.domain.user.CustomerNumber;

import java.util.Optional;

@Repository
public interface CustomerRepository {

    Optional<Customer> get(CustomerNumber customerNumber);

    void add(Customer customer);

}
