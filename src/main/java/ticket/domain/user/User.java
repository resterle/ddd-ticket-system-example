package ticket.domain.user;

import ticket.domain.UserID;

public abstract class User {

    private final UserID id;
    private final String name;

    protected User(UserID id, String name){
        this.id = id;
        this.name = name;
    }

    public UserID getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
