package ticket.domain.user;

import ticket.domain.UserID;

public class Employee extends User {

    final private String employeeNumber;

    protected Employee(UserID id, String name, String employeeNumber) {
        super(id, name);
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber(){
        return this.employeeNumber;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        protected UserID id;
        protected String name;
        protected String employeeNumber;

        public Employee build() {
            return new Employee(id, name, employeeNumber);
        }

        public Builder id(UserID id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder employeeNumber(String customerNumber){
            this.employeeNumber = customerNumber;
            return this;
        }
    }
}