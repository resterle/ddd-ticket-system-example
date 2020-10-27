package ticket.infrastructure.persistence;

import ticket.domain.CustomerRepository;
import ticket.domain.user.Customer;
import ticket.domain.user.CustomerNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<CustomerNumber, Customer> storage = new HashMap<>();

    @Override
    public Optional<Customer> get(CustomerNumber id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void add(Customer customer) {
        storage.put(customer.getCustomerNumber(), customer);
    }
}
