package ticket.domain.user;

import ticket.domain.UserID;

public class Admin extends Employee {
    protected Admin(UserID id, String name, String employeeNumber) {
        super(id, name, employeeNumber);
    }

    public static class Builder extends Employee.Builder{

        public Admin build() {
            return (Admin) super.build();
        }
    }
}
