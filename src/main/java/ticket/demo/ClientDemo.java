package ticket.demo;

import ticket.domain.*;
import ticket.domain.user.Customer;
import ticket.domain.user.Membership;

public class ClientDemo {

    private static final UserID JANE = new UserID("Jane");
    private static final UserID BOB = new UserID("Bob");

    public static void main(String[] args) throws IllegalStateTransitionException {

        // Jane creates new ticket

        Ticket ticket = new DemoFactory()
                .createNewTicket(JANE, "Wrong price calculation", "...");
        ticket.watch(JANE);
        ticket.assignTo(BOB);

        info(ticket);

        // Bob analyzes ticket

        ticket.watch(BOB);
        ticket.apply(Action.START_PROGRESS);
        ticket.addComment("Could reproduce and detected that...", BOB);
        ticket.addAttachment(new Attachment(BOB, "http://cms.example.com/4711", "Stacktrace"));

        info(ticket);

        // Bob solves ticket
        ticket.updateDescription("Wrong price calculation has root cause ....");
        ticket.apply(Action.RESOLVE);
        ticket.apply(Action.CLOSE);
        ticket.unwatch(BOB);

        info(ticket);


        Customer customer = Customer.builder()
                .id(new UserID())
                .name("Hans")
                .activeMembership(Membership.BASIC)
                .customerNumber("4711")
                .build();

        customer.get

    }

    private static void info(Object msg) {
        System.out.println(msg);
    }

}
