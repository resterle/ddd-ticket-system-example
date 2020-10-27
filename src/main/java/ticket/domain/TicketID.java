package ticket.domain;

import stereotypes.ValueObject;

import java.io.Serializable;
import java.util.Objects;

@ValueObject
public class TicketID extends AbstractIdValue{

    public TicketID(String id) {
        super(id);
    }

    public TicketID() {
    }
}
