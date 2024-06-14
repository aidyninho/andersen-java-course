package model.base;

import model.Role;

public abstract class User {

    private long id;
    private Role role;

    public User(long id, Role role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void printRole() {
        System.out.println(this.role);
    }
}
