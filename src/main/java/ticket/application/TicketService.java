package ticket.application;

import org.springframework.stereotype.Service;
import ticket.domain.*;
import ticket.domain.user.Customer;
import ticket.domain.user.CustomerNumber;

import java.util.Optional;

@Service
public class TicketService {

    private final TicketFactory factory;

    private final TicketRepository ticketRepository;

    private final CustomerRepository customerRepository;

    public TicketService(TicketFactory factory, TicketRepository ticketRepository, CustomerRepository customerRepository) {
        this.factory = factory;
        this.ticketRepository = ticketRepository;
        this.customerRepository = customerRepository;
    }

    public Ticket createTicket(CustomerNumber reporterId, String title, String description, UserID... watcher) {
        Optional<Ticket> maybeTicket = customerRepository.get(reporterId)
            .map(reporter -> {
                Ticket ticket = factory.createNewTicket(reporter, title, description);
                ticket.watch(reporter.getId());
                for (UserID w : watcher) {
                    ticket.watch(w);
                }
                return ticket;
            });
        maybeTicket.ifPresent(ticketRepository::add);
        return maybeTicket.orElse(null);
    }

    public Optional<Ticket> findTicket(TicketID id) {
        return ticketRepository.get(id);
    }

    public SearchResult searchTicket(SearchCriteria criteria, PageRequest pageRequest) {
        return ticketRepository.search(criteria, pageRequest);
    }

    public void update(Ticket ticket) {
        ticketRepository.update(ticket);
    }

}
