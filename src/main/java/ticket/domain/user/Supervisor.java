package ticket.domain.user;

import ticket.domain.UserID;

import java.util.Set;

public class Supervisor extends Employee {

    final Set<EmployeeNumber> supervisedEmployees;

    protected Supervisor(UserID id, String name, EmployeeNumber employeeNumber, Set<EmployeeNumber> supervisedEmployees) {
        super(id, name, employeeNumber);
        this.supervisedEmployees = supervisedEmployees;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Employee.Builder{}
}
