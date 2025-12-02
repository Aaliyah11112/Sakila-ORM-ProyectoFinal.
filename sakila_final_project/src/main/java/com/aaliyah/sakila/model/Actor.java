package com.aaliyah.sakila.model;

public class Actor extends Entity {
    private String firstName;
    private String lastName;

    public Actor() {}
    public Actor(int id, String firstName, String lastName) { super(id); this.firstName = firstName; this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override public String toString() {
        return "Actor{id="+id+", name='"+firstName+" "+lastName+"'}";
    }
}
