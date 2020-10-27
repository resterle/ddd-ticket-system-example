package ticket.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class AbstractIdValue implements Serializable {

    protected final String id;

    protected AbstractIdValue(String id) {
        this.id = id;
    }

    protected AbstractIdValue() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIdValue userID = (AbstractIdValue) o;
        return Objects.equals(id, userID.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
