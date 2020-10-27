package ticket.domain;

import ticket.domain.user.Customer;
import ticket.domain.user.CustomerNumber;
import ticket.domain.user.EmployeeNumber;

public class TicketFactory {

    private final DomainEventPublisher publisher;
    private final TicketIdGenerator idGenerator;

    public TicketFactory(DomainEventPublisher publisher, TicketIdGenerator idGenerator) {
        this.publisher = publisher;
        this.idGenerator = idGenerator;
    }

    public Ticket createNewTicket(Customer reporter, String title, String description) {
        Ticket ticket = ticketBuilder(idGenerator.next(), reporter, Status.NEW)
                .withTitle(title)
                .withDescription(description)
                .build();
        ticket.watch(reporter.getId());
        publisher.publish(new TicketCreated(ticket.getId(), "Created new ticket."));
        return ticket;
    }

    public TicketBuilder ticketBuilder(TicketID id, Customer reporter, Status status) {
        return new TicketBuilder(id, reporter, status);
    }

    public class TicketBuilder {

        private final TicketID id;
        private final CustomerNumber reporter;
        private EmployeeNumber assignee;
        private String title;
        private String description;
        private final Status status;

        TicketBuilder(TicketID id, Customer reporter, Status status) {
            this.id = id;
            this.reporter = reporter.getCustomerNumber();
            this.status = status;
        }

        public TicketBuilder withAssignee(EmployeeNumber assignee) {
            this.assignee = assignee;
            return this;
        }

        public TicketBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public TicketBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Ticket build() {
            return new Ticket(publisher, id, status, title, description, reporter, assignee);
        }

    }

}
