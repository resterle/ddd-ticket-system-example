package ticket.demo;

import ticket.domain.*;
import ticket.domain.user.Customer;
import ticket.domain.user.CustomerNumber;
import ticket.domain.user.Employee;
import ticket.domain.user.EmployeeNumber;

public class ClientDemo {

    private static final Customer JANE = Customer.builder()
        .name("Jane")
        .customerNumber(new CustomerNumber("customer-0"))
        .build();
    private static final Employee BOB = Employee.builder()
        .name("Bob")
        .employeeNumber(new EmployeeNumber("employee-0"))
        .build();

    public static void main(String[] args) throws IllegalStateTransitionException {

        // Jane creates new ticket

        Ticket ticket = new DemoTicketFactory()
                .createNewTicket(JANE, "Wrong price calculation", "...");
        ticket.watch(JANE.getId());
        ticket.assignTo(BOB.getEmployeeNumber());

        info(ticket);

        // Bob analyzes ticket

        ticket.watch(BOB.getId());
        ticket.apply(Action.START_PROGRESS);
        ticket.addComment("Could reproduce and detected that...", BOB.getId());
        ticket.addAttachment(new Attachment(BOB.getId(), "http://cms.example.com/4711", "Stacktrace"));

        info(ticket);

        // Bob solves ticket
        ticket.updateDescription("Wrong price calculation has root cause ....");
        ticket.apply(Action.RESOLVE);
        ticket.apply(Action.CLOSE);
        ticket.unwatch(BOB.getId());

        info(ticket);
    }

    private static void info(Object msg) {
        System.out.println(msg);
    }

}
