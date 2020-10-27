package ticket.domain.user;

import ticket.domain.AbstractIdValue;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class EmployeeNumber extends AbstractIdValue {
    public EmployeeNumber(String id) {
        super(id);
    }

    public EmployeeNumber() {
    }
}
