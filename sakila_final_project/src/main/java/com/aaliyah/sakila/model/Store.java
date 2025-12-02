package com.aaliyah.sakila.model;

public class Store extends Entity {
    private Address address; 
    private Staff manager; 

    public Store() {}
    public Store(int id, Address address, Staff manager) { super(id); this.address = address; this.manager = manager; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Staff getManager() { return manager; }
    public void setManager(Staff manager) { this.manager = manager; }

    @Override public String toString() {
        return "Store{id="+id+"}";
    }
}
