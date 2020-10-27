package ticket.domain.user;

import ticket.domain.UserID;

public class Customer extends User {

    private final CustomerNumber customerNumber;
    private final Membership activeMembership;

    protected Customer(UserID id, String name, CustomerNumber customerNumber, Membership activeMembership) {
        super(id, name);
        this.customerNumber = customerNumber;
        this.activeMembership = activeMembership;
    }

    public CustomerNumber getCustomerNumber(){
        return this.customerNumber;
    }

    public Membership getActiveMembership(){
        return this.activeMembership;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private UserID id;
        private String name;
        private CustomerNumber customerNumber;
        private Membership activeMembership;

        public Customer build() {
            return new Customer(id, name, customerNumber, activeMembership);
        }

        public Builder id(UserID id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder customerNumber(CustomerNumber customerNumber){
            this.customerNumber = customerNumber;
            return this;
        }

        public Builder activeMembership(Membership activeMembership){
            this.activeMembership = activeMembership;
            return this;
        }
    }
}
