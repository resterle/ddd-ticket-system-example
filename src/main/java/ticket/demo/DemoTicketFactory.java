package ticket.demo;

import ticket.domain.*;

public class DemoTicketFactory extends TicketFactory {

    private static int sequenceGen = 0;

    public DemoTicketFactory() {
        super(new DomainEventPublisher() {
            @Override
            public void publish(TicketEvent event) {
                System.out.println(event);
            }
        }, new TicketIdGenerator() {
            @Override
            public TicketID next() {
                return new TicketID(String.valueOf(++sequenceGen));
            }
        });
    }


}
