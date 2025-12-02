package com.aaliyah.sakila.model;

public class Customer extends Entity {
    private String firstName;
    private String lastName;
    private Address address; 

    public Customer() {}
    public Customer(int id, String firstName, String lastName, Address address) {
        super(id); this.firstName = firstName; this.lastName = lastName; this.address = address;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override public String toString() {
        return "Customer{id="+id+", name='"+firstName+" "+lastName+"'}";
    }
}
