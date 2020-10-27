package ticket.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserID extends AbstractIdValue {
    public UserID(String id) {
        super(id);
    }

    public UserID() {
    }
}
